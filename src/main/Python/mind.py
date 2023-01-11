"""
1. 是32-d usr vec和序列多兴趣拼接，再fc变为32-d的用户多兴趣
2. 使用了长期序列的各个特征，
3. 使用了短期序列的各个特征，长短期序列拼接为len=40的序列，短期序列在左，长期序列在右, 拼接后历史序列维度 = [-1, 40, 56]

"""

import sys, os

sys.path.append('../release/python')
import tensorflow as tf
import mlx.python.tf as tfmlx
from mlx.python.util.graph_state_helper import graph_state_helper
# u2i sparse fea
global g_mlx_feature_names  # 原特征名。没啥用
global g_mlx_embed_names  # 全部特征名，embed之后. emb_output.name
global g_mlx_embed_mapping  # 全部特征kv映射. emb_output.name -> emb_output
# seq
global g_mlx_seq_feature_names
global g_mlx_embed_seq_mapping  # All sparse mlx emb/feature name, emb seq op map
global g_mlx_embed_mask_mapping  # All sparse mlx emb/feature name, emb mask op map
# 特征分组
global g_my_name_collections  # 特征分组用，将全部特征分为多组，每组内包含各个特征名. key=给某类特征起的名字, val=该类下各个特征名的lst

g_mlx_feature_names = []
g_mlx_embed_names = []
g_mlx_embed_mapping = {}
g_mlx_seq_feature_names = []
g_mlx_embed_seq_mapping = {}
g_mlx_embed_mask_mapping = {}

g_my_name_collections = {}  # 对特征kv映射做了分组。


# 如果希望原生MLX模型翻译后Variable定义完全一致，请仿照此处自行定义全连接网络
# tf.layers.dense产生的W矩阵是原生MLX FullyConnected中W矩阵的转置。全都用add_fc。。。
def add_fc(input_var, units, activation=None, name='fc'):
    input_dim = int(input_var.shape[-1])
    var_w = tf.get_variable(    # 同变量名的变量共享使用。
        '%s_w' % name, [units, input_dim],
        initializer=tfmlx.xavier_initializer(mode='COUNT_COL')
    )
    var_b = tf.get_variable(
        '%s_b' % name, [1, units],
        initializer=tf.zeros_initializer()
    )
    h = tf.matmul(input_var, var_w, transpose_b=True) + var_b
    if activation:
        return activation(h)
    return h


def get_shape(inputs):
    # 获取inputs shape。
    # tf.variable_scope()内使用emb_dim时，用get_shape(), 用tf.shape()会在add_fc那里报错，很奇怪。
    dynamic_shape = tf.shape(inputs)
    static_shape = inputs.get_shape().as_list()
    shape = []
    for i, dim in enumerate(static_shape):
        shape.append(dim if dim is not None else dynamic_shape[i])

    return shape


class Model_ComiRec_SA(tf.keras.Model):
    """
    self-att
    """

    def __init__(self, caps_dim, num_interest, seq_len=256, add_pos=False, hard_readout=True, relu_layer=True):
        super(Model_ComiRec_SA, self).__init__()

        self.caps_dim = caps_dim
        self.caps_num = num_interest
        self.seq_len = seq_len
        self.add_pos = add_pos
        self.hard_readout = hard_readout
        self.relu_layer = relu_layer  #

    def call(self, inputs):
        """
        :param hist_embs:       历史行为emb，shape = (batch_size, seq_len, dim0) # item hist, d-8
        :param item_emb:        正样本emb, shape = (batch_size, dim1)  # item fea, d-32
        :param hist_mask:       shape = (batch_size, len)
        :param other_feas:      shape=(batch_size, dim2)    # user fea, d-32
        :return:
        """
        hist_embs, item_emb, hist_mask, other_feas = inputs
        hist_dim = hist_embs.shape[-1]

        if self.add_pos:
            with tf.variable_scope("position", reuse=tf.AUTO_REUSE):
                position_embedding = tf.get_variable(
                    'position_embedding', [self.seq_len, hist_dim])  # 即建立一个len * dim的矩阵做为位置向量
            position_embedding = tf.expand_dims(position_embedding, axis=0) # (1, len, dim)
            item_list_add_pos = hist_embs + position_embedding
        else:
            item_list_add_pos = hist_embs

        num_heads = self.caps_num
        with tf.variable_scope("self_atten", reuse=tf.AUTO_REUSE) as scope:
            item_list_add_pos = tf.reshape(item_list_add_pos, [-1, hist_dim])   # (batch_sz*len, hist_dim)
            # 1. 历史输入做变换，ComiRec-eq6
            # (batch_sz, seq_len, dim * num_caps)
            item_hidden = add_fc(item_list_add_pos, self.caps_dim * 4, activation=tf.nn.tanh, name='att_w1')
            # (batch_sz, seq_len, num_heads)
            item_att_w = add_fc(item_hidden, num_heads, activation=None, name='att_w2')
            item_att_w = tf.reshape(item_att_w, [-1, self.seq_len, num_heads])
            # (batch_sz, num_heads, seq_len)
            item_att_w = tf.transpose(item_att_w, [0, 2, 1])

            # (batch_sz, num_heads, seq_len)
            atten_mask = tf.tile(tf.expand_dims(hist_mask, axis=1), [1, num_heads, 1])
            paddings = tf.ones_like(atten_mask) * (-2 ** 32 + 1)  # 空位置的权重赋予极小值

            item_att_w = tf.where(tf.equal(atten_mask, 0), paddings, item_att_w)
            item_att_w = tf.nn.softmax(item_att_w)  # 和capsule不同，这个是在seq_len层面上做权重归一

            # 2. 用户多兴趣，ComiRec-eq7
            # (batch_sz, num_heads, dim)
            interest_emb = tf.matmul(item_att_w, hist_embs)

        # 核心：(batch_sz, num_heads, dim), 每个用户的seq_len个历史行为，压缩为num_caps个用户兴趣
        interest_capsule = interest_emb
        with tf.variable_scope('relu_out', reuse=tf.AUTO_REUSE):
            if self.relu_layer:  # relu激活
                other_feas = tf.expand_dims(other_feas, axis=1)             # (batch_size, 1, dim2)
                other_feas = tf.tile(other_feas, [1, num_heads, 1]) # (batch_size, num_caps, dim2)
                interest_capsule = tf.concat([interest_capsule, other_feas], axis=2)    # (batch_sz, num_caps, dim+dim2)
                interest_capsule = tf.reshape(interest_capsule, [-1, interest_capsule.shape[-1]])
                interest_capsule = add_fc(interest_capsule, self.caps_dim, activation=tf.nn.relu, name='proj')
                interest_capsule = tf.reshape(interest_capsule, [-1, num_heads, self.caps_dim])

        # 后续：使用正样本对num_caps个用户兴趣做att， xMIND-3.4节
        # 即num_caps个用户兴趣分到权重后组合，得到最终用户单向量的兴趣表达
        atten = tf.matmul(interest_capsule, tf.reshape(item_emb, [-1, self.caps_dim, 1]))  # (batch_sz, num_caps, 1)
        atten = tf.nn.softmax(tf.pow(tf.reshape(atten, [-1, num_heads]), 1))  # (batch_sz, num_caps)

        # final usr vec, readout.shape=(batch_sz, dim)
        if self.hard_readout:
            # 只取caps权重最大的那个vec
            readout = tf.gather(tf.reshape(interest_capsule, [-1, self.caps_dim]),  # (batch_sz * num_caps, dim)
                                tf.argmax(atten, axis=1, output_type=tf.int32) +  # (batch_sz,)
                                tf.range(tf.shape(hist_embs)[0]) * num_heads)  # (batch_sz,)
        else:
            # 每个caps都做贡献
            readout = tf.matmul(tf.reshape(atten, [-1, 1, num_heads]), interest_capsule)
            readout = tf.reshape(readout, [-1, self.caps_dim])

        return interest_capsule, readout



conf = {
    "user_sparse_list": [
        "1  F_GENDER    2",
        "2  F_AGE   4",
        "3  F_CONSTELLATION 4",
        "4  F_MARRIED   2",
        "5  F_JOB   4",
        "6  F_USER_LEVEL    4",
        # "7  F_U_CITYID  6",
        "8  F_U_LOC_CITYID  6",
        # "9  F_CLIENT_TYPE   4",
        # "10 F_RESLUTION 4",
        # "11 F_AGENT 4",
        # "12 F_APP_SOURCE    4",
        # "13 F_APP_VERSION   4",
        # "14 F_EXP_U_30D_EXPOSURE_CNT    4",
        # "15 F_U_ALL_EXP_CNT 4",
        # "16 F_EXP_U_30D_CLK_CNT 4",
        # "17 F_U_CLK_AVG_POS 4",
        "18 F_UID   16",
        "19 F_USERID0   2",
        "20 F_USER_ALL_ORDER_NUM    4",
        # "21 F_HP_CLICKED_PASSED_TIME    4",
        "46 F_U_IIDS_6H 16",
        "47 F_U_ORDER_IIDS_6H   12",
        "48 F_U_ORDER_CLASSES_6H    8",
        "49 F_U_ORDER_TYPES_6H  8",
        "50 F_U_ORDER_CATES_6H  8",
        "51 F_U_CLASSES_6H  8",
        "52 F_U_TYPES_6H    8",
        "53 F_U_CATES_6H    8",
        "54 F_U_ORDER_BRANDS_6H 12",
        "55 F_U_BRANDS_6H   12",
        "56 F_U_IIDS_24H    12",
        "57 F_U_ORDER_CLASSES_24H   8",
        "58 F_U_ORDER_TYPES_24H 8",
        "59 F_U_CLASSES_24H 8",
        "60 F_U_TYPES_24H   8",
        "61 F_U_CATES_24H   8",
        "62 F_USER_DISPLAYED_ITEM_NUM   6",
        "63 F_USER_DISLAYED_AND_VIEW_ITEM_NUM   6",
        "64 F_USER_DISPLAYED_AND_ORDER_ITEM_NUM 6",
        "65 F_USER_DISPLAYED_CLASS_ID   8",
        "66 F_USER_DISPLAYED_CATE_ID    8",
        "67 F_USER_DISPLAYED_AND_VIEW_CLASS_ID  8",
        "68 F_USER_DISPLAYED_AND_VIEW_CATE_ID   8",
        "69 F_U_ORDER_BRANDS_24H    12",
        "70 F_U_BRANDS_24H  12",
        "71 F_U_IIDS_30D    12",
        "72 F_U_ORDER_IIDS_120D 12",
        "73 F_U_ORDER_CLASSES_120D  8",
        "74 F_U_ORDER_TYPES_120D    8",
        "75 F_U_ORDER_CATES_120D    8",
        "76 F_U_CLASSES_30D 8",
        "77 F_U_TYPES_30D   8",
        "78 F_U_CATES_30D   8",
        "79 F_U_ORDER_BRANDS_120D   12",
        "80 F_U_BRANDS_30D  12",
        "81 F_USER_1H_MOST_VIEW_CATE    8",
        "82 F_USER_1H_MOST_VIEW_TYPE    8",
        "83 F_USER_1H_MOST_VIEW_CLASS   8",
        "84 F_USER_1H_MOST_TWO_VIEW_CATE    8",
        "85 F_USER_1H_MOST_THREE_VIEW_CLASS 8",
        "86 F_USER_6H_MOST_VIEW_TYPE    8",
        "87 F_USER_6H_MOST_THREE_VIEW_CLASS_LIST    8",
        "88 F_USER_1W_MOST_THREE_VIEW_CLASS 8",
        "89 F_1D_LAST_VIEW_TWO_CATES    8",
        "90 F_1D_LAST_VIEW_THREE_CLASS  8",
        "91 F_3D_LAST_VIEW_CATES    8",
        "92 F_3D_LAST_VIEW_TWO_CLASS    8",
        "93 F_3D_LAST_VIEW_THREE_CLASS  8",
        "94 F_1W_LAST_VIEW_CATES    8",
        "95 F_1W_LAST_VIEW_TWO_CLASS    8",
        "96 F_ALL_LAST_VIEW_CATES   8",
        "97 F_2H_LAST_ORDER_TYPES   8",
        "98 F_2H_LAST_ORDER_CLASS   8",
        "99 F_2H_LAST_ORDER_TWO_CATES   8",
        "100    F_12H_LAST_ORDER_TWO_TYPES  8",
        "101    F_2D_LAST_ORDER_THREE_CLASS 8",
        "102    F_1W_LAST_ORDER_CATES   8",
        "103    F_1W_LAST_ORDER_TWO_CATES   8",
        "104    F_1W_LAST_ORDER_THREE_CLASS 8",
        "105    F_PAGE_INDEX    6",
    ],

    "item_sparse_list": [
        "22  F_IID 4",
        # "23 F_DTYPE 4",
        "24 F_CLASS 4",
        "25 F_TYPE 4",
        "26 F_CATE 4",
        "27 F_BRAND 4",
        "28 F_APPOINTMENT 4",
        "29 F_DISCOUNT_SEG 4",
        "30 F_PRICE 4",
        "31 F_MEAL_CNT 4",
        "32 F_AVGPRICEPERPERSON 4",
        "205 F_I_FIVE_BU_NAME 4",   # bu_name
        "494 F_I_NEW_CATE_NAME 4",
        "495 F_I2I_SEQ_20 8",
    ],

    "scene_sparse_list": [
        "37  F_WEEKDAY 4",
        "38  F_HOUR 4",
        "39  F_WEATHER 4",
        "40  F_U_GENERIC_GEOHASH 4",
        "41  F_U_GEOHASH 4",
    ],

    # seq特征
    "seq_len": 20,  # 这批特征序列长度最大是20，且按时间倒序。
    "click_seq_long_term_list": [
        "466    F_CLICK_FREQ_SEQ_IID_20    16",  # 目前数据中只记录了id seq
        "467    F_CLICK_FREQ_SEQ_DTYPE_20    4",
        "468    F_CLICK_FREQ_SEQ_MENTAL_20    4",
        "469    F_CLICK_FREQ_SEQ_WEEK_20    4",
        "470    F_CLICK_FREQ_SEQ_HOUR_20    4",
        "471    F_CLICK_FREQ_SEQ_TIMEGAP_20    4",  # 1856,64,64,1792,768,512,1536,512,1536,1536,512,512,1536,1536,1536,1536,1536,512,1536,1536
        "472    F_CLICK_FREQ_SEQ_CNT_20    4",
    ],
    "click_seq_short_term_list": [
        "480    F_CLICK_IIDSEQ_20    16",
        "481    F_CLICK_DTYPESEQ_20    4",
        "482    F_CLICK_MENTALSEQ_20    4",
        "483    F_CLICK_HOURSEQ_20    4",
        "484    F_CLICK_WEEKSEQ_20    4",
        "485    F_CLICK_GAPSEQ_20    4",
        "486    F_CLICK_CNTSEQ_20    4",
    ],
    "order_seq_list": [
        # "473    F_ORDER_FREQ_SEQ_IID_20    8",
        # "474    F_ORDER_FREQ_SEQ_DTYPE_20    8",
        # "475    F_ORDER_FREQ_SEQ_MENTAL_20    8",
        # "476    F_ORDER_FREQ_SEQ_WEEK_20    8",
        # "477    F_ORDER_FREQ_SEQ_HOUR_20    8",
        # "478    F_ORDER_FREQ_SEQ_TIMEGAP_20    8",
        # "479    F_ORDER_FREQ_SEQ_CNT_20    8",

        # "487    F_ORDER_IIDSEQ_20    8",
        # "488    F_ORDER_DTYPESEQ_20    8",
        # "489    F_ORDER_MENTALSEQ_20    8",
        # "490    F_ORDER_HOURSEQ_20    8",
        # "491    F_ORDER_WEEKSEQ_20    8",
        # "492    F_ORDER_GAPSEQ_20    8",
        # "493    F_ORDER_CNTSEQ_20    8",
    ]
}


# 定义sparse特征
def build_emb(sparse_name):
    sparse_features = []
    sparse_feature_list = conf[sparse_name]
    for i, fea_info in enumerate(sparse_feature_list):
        cid = int(fea_info.split()[0])
        name = str(fea_info.split()[1])
        _ = int(fea_info.split()[2])
        feature = tfmlx.create_sparse_feature(cid, name)
        sparse_features.append(feature)
    return sparse_features


def build_model():
    # 1. 特征处理
    # 构建tensor
    # 根据colid构建user/item/scene/seq tensor
    user_embed = build_emb("user_sparse_list")
    item_embed = build_emb("item_sparse_list")
    scene_embed = build_emb("scene_sparse_list")
    seq_embed_long = build_emb("click_seq_long_term_list")
    seq_embed_short = build_emb("click_seq_short_term_list")
    # 为sparse特征添加linear部分
    # 目前由于框架限制，sparse特征只有添加了linear部分才可以创建embedding
    # 即tfmlx.linear_column()等价于原生MLX版本中的m.add_col()
    sparse_embed = user_embed + item_embed + scene_embed + seq_embed_long + seq_embed_short
    linear_column = tfmlx.linear_column(sparse_embed)  # 等价于 m.add_col()

    global g_my_name_collections
    # 这里将一部分Embedding加入到自定义的全局集合映射里，方便在TF模型中使用
    # TF模型中无法根据外部的变量名索引embedding变量
    g_my_name_collections['user_embed'] = [x.name for x in user_embed]
    g_my_name_collections['scene_embed'] = [x.name for x in scene_embed]
    g_my_name_collections['item_embed'] = [x.name for x in item_embed]
    g_my_name_collections['seq_embed_long'] = [x.name for x in seq_embed_long]
    g_my_name_collections['seq_embed_short'] = [x.name for x in seq_embed_short]

    # 把所有的sparse特征压入map，namestr->tensor
    sparse_list = conf['user_sparse_list'] + conf['item_sparse_list'] + conf['scene_sparse_list']
    for i, fea_info in enumerate(sparse_list):
        _ = int(fea_info.split()[0])
        name = str(fea_info.split()[1])
        dim = int(fea_info.split()[2])
        if dim > 0:
            sf = tfmlx.get_sparse_feature_by_name(name)
            # 对稀疏特征创建Embedding定义，仅定义Embedding维度即可
            emb_var = tfmlx.embedding_column(sf, dimensions=dim, combiner='sum')
            # 使用get_output方法获得输入特征经Embedding转换后且经过combiner操作后的实际数值
            # 注意：与TF需要自己处理输入数据并进行embedding_lookup不同，这里不涉及任何对原始输入数据的操作
            # 原始输入数据（如libsvm格式数据）的解析和embedding填充是在MLX框架内部完成的
            emb_output = emb_var.get_output()

            g_mlx_feature_names.append(name)
            g_mlx_embed_names.append(emb_output.name)
            g_mlx_embed_mapping[name] = emb_output
            g_mlx_embed_mapping[emb_output.name] = emb_output
    # 序列特征压入list和map  g_mlx_seq_feature_names  g_mlx_embed_seq_mapping  g_mlx_embed_mask_mapping
    seq_max_len = conf['seq_len']
    seq_list = conf['click_seq_long_term_list'] + conf['click_seq_short_term_list']
    for i, fea_info in enumerate(seq_list):
        items = fea_info.split()
        name = str(items[1])
        dim = int(items[2])
        f = tfmlx.get_sparse_feature_by_name(name)
        emb_var = tfmlx.embedding_column(f, dimensions=dim, combiner='concat_1d', max_seq_len=seq_max_len)
        emb_output = emb_var.get_output()
        emb_mask = emb_var.get_seq_mask()

        g_mlx_seq_feature_names.append(name)
        g_mlx_embed_seq_mapping[name] = emb_output
        g_mlx_embed_mask_mapping[name] = emb_mask

    # 2. 标签,此处取出样本中序号为0的标签
    label = tfmlx.get_labels(indexes=[0], name="label0")
    # 样本权重,同上
    sample_weight1 = tfmlx.get_sample_weights(indexes=[0], name="sample_weight0")
    is_training = True
    embeddings = [g_mlx_embed_mapping[x] for x in g_mlx_embed_names]
    seq_embeddings = [g_mlx_embed_seq_mapping[x] for x in g_mlx_seq_feature_names]
    seq_embeddings_mask = [g_mlx_embed_mask_mapping[x] for x in g_mlx_seq_feature_names]

    # 3. 调用TF Model
    model(
        # 注意这里输入用户定义的Embedding时，必须保证顺序!
        # 另外注意，这里传入的变量不能重复
        embeddings, seq_embeddings, seq_embeddings_mask,
        label,
        sample_weight1,
        is_training)

    # 4. 创建优化器,此处定义的参数仍然可以被外部训练配置覆盖
    adam_opt = tfmlx.Adam(1e-5, l2_regularization=1e-7)
    ftrl_opt = tfmlx.Ftrl(1e-4, l1_regularization=1e-6)
    sadam_opt = tfmlx.Sadam(1e-5, l2_regularization=1e-7)

    ftrl_opt.optimize(tfmlx.LINEAR_VARIABLES)
    adam_opt.optimize(tfmlx.GRAPH_VARIABLES)
    sadam_opt.optimize(tfmlx.EMBEDDING_VARIABLES)
    tfmlx.set_filter(capacity=1 << 22, min_cnt=5)
    tfmlx.set_col_max_train_epoch(1)

    return tfmlx.get_model()


extra_graph_states = [
    graph_state_helper('TRAIN'),
    graph_state_helper('EVALUATE'),
    graph_state_helper('PREDICT', 'default'),
    graph_state_helper('PREDICT', 'user_on_predict_cap1'),
    graph_state_helper('PREDICT', 'user_on_predict_cap2'),
    graph_state_helper('PREDICT', 'user_on_predict_cap3'),
    graph_state_helper('PREDICT', 'user_on_predict_cap4'),
    graph_state_helper('PREDICT', 'item_on_predict')
]


@tfmlx.tf_wrapper(extra_graph_states, no_default_states=True)
def model(embeddings, seq_embeddings, seq_embeddings_mask, label1, sample_weight1, is_training, **kwargs):
    global g_mlx_feature_names
    global g_mlx_seq_feature_names

    # 这里建立(MLX变量名->TF变量)和(TF变量名->MLX变量名)的映射关系,便于使用
    namestr2tensor_embed_mapping = {
        x[0]: x[1] for x in zip(g_mlx_feature_names, embeddings)
    }
    # 序列特征的key-val，相当于还原为原先的g_mlx_embed_seq_mapping
    namestr2tensor_seq_mapping = {
        x[0]: x[1] for x in zip(g_mlx_seq_feature_names, seq_embeddings)
    }
    namestr2tensor_seqmask_mapping = {
        x[0]: x[1] for x in zip(g_mlx_seq_feature_names, seq_embeddings_mask)
    }

    def get_my_collection(name):
        global g_my_name_collections
        if name not in g_my_name_collections:  # name指某一组特征，比如这块全是用户特征。
            raise Exception('Cannot find collection: ' + name)
        return [namestr2tensor_embed_mapping[x] for x in g_my_name_collections[name]]  # 取出所有用户特征

    def get_emb_seq_collection(name):
        global g_my_name_collections
        if name not in g_my_name_collections:
            raise Exception('Cannot find collection in get_seq_collection: ' + name)
        return [namestr2tensor_seq_mapping[x] for x in g_my_name_collections[name]]

    def get_mask_seq_collection(name):
        global g_my_name_collections
        if name not in g_my_name_collections:
            raise Exception('Cannot find collection in get_seq_collection: ' + name)
        return [namestr2tensor_seqmask_mapping[x] for x in g_my_name_collections[name]]

    # get variable collections by self-defined names
    # 获取各组变量
    user_embed = get_my_collection('user_embed')    # 各变量shape=(-1, dim)
    scene_embed = get_my_collection('scene_embed')  # 各变量shape=(-1, dim)
    item_embed = get_my_collection('item_embed')    # 各变量shape=(-1, dim)
    seq_embed_long = get_emb_seq_collection('seq_embed_long') # 各变量shape=(-1, len, dim)
    seq_embed_long_mask = get_mask_seq_collection('seq_embed_long')[0]    # 各变量shape=(-1, len)
    seq_embed_short = get_emb_seq_collection('seq_embed_short')
    seq_embed_short_mask = get_mask_seq_collection('seq_embed_short')[0]

    '''
    https://zhuanlan.zhihu.com/p/52055580, 通俗理解tf.name_scope()、tf.variable_scope()
    在tf.variable_scope的作用域下，通过get_variable()可以使用已经创建的变量，实现了变量的共享，
    即可以通过get_variable()在tf.variable_scope设定的作用域范围内进行变量共享。
    reuse=tf.AUTO_REUSE，不同变量域之间也可以互相用？
    '''
    output_emb_dim = 32
    seq_len = conf['seq_len']
    # user part
    with tf.variable_scope('user_dnn'):    # resue到底加不加？
        user_concat = tf.concat(user_embed + scene_embed, 1)    # shape=(-1, dim)
        user_fc_input = user_concat
        for units in [256, 128]:
            name = 'user_fc%d' % units
            user_fc_input = add_fc(user_fc_input, units, tf.nn.relu, name)
        user_fc_out = add_fc(user_fc_input, output_emb_dim, None, 'user_fc32')
        normalize_user_fc_out = tf.nn.l2_normalize(user_fc_out, 1)  # (batch_sz, dim)

    # item part
    with tf.variable_scope('item_dnn'):
        item_concat = tf.concat(item_embed, 1)  # shape=(-1, dim)
        item_fc_input = item_concat
        for units in [256, 128]:
            name = 'item_fc%d' % units
            item_fc_input = add_fc(item_fc_input, units, tf.nn.relu, name)
        item_fc_out = add_fc(item_fc_input, output_emb_dim, None, 'item_fc32')
        normalize_item_fc_out = tf.nn.l2_normalize(item_fc_out, 1)  # (batch_sz, dim)

    # seq part
    # 序列特征拼接
    # key-mask: (batch_sz, seq_len, dim1+dim2+...)/(batch_sz, seq_len)
    click_seq_long_embs = tf.concat([tf.reshape(one_seq, [-1, seq_len, one_seq.shape[-1] // seq_len]) for one_seq in seq_embed_long],
                                    axis=-1)
    click_seq_long_mask = tf.reshape(seq_embed_long_mask, [-1, seq_len])
    click_seq_short_embs = tf.concat([tf.reshape(one_seq, [-1, seq_len, one_seq.shape[-1] // seq_len]) for one_seq in seq_embed_short],
                                     axis=-1)
    click_seq_short_mask = tf.reshape(seq_embed_short_mask, [-1, seq_len])
    # (batch_sz, num_caps, dim)/(batch_sz, dim)
    # interest_capsule, readout = CapsuleNetwork(caps_dim=32, seq_len=conf['seq_len'], bilinear_type=2, num_interest=4)(
    #     [click_keys_seqs_embs,
    #      normalize_item_fc_out,
    #      click_keys_seqs_mask,
    #      normalize_user_fc_out])
    # key-mask: (batch_sz, seq_len*2, dim1+dim2+...)/(batch_sz, seq_len*2)
    click_seq_embs = tf.concat([click_seq_short_embs, click_seq_long_embs], axis=1)
    click_seq_mask = tf.concat([click_seq_short_mask, click_seq_long_mask], axis=1)
    interest_capsule, readout = Model_ComiRec_SA(caps_dim=output_emb_dim, num_interest=4,
                                                 seq_len=seq_len * 2, add_pos=False, hard_readout=True)(
        [click_seq_embs,
         normalize_item_fc_out,
         click_seq_mask,
         normalize_user_fc_out])

    # loss部分
    # similarity part
    similarity_scores = tf.reduce_sum(
        # tf.multiply(normalize_user_fc_out, normalize_item_fc_out),
        tf.multiply(readout, normalize_item_fc_out),
        axis=1,
        keepdims=True)
    # print('similarity_scores', similarity_scores)

    var_scalar = tf.get_variable('scalar_w', [1, 1], initializer=tf.zeros_initializer(), dtype=tf.float32)
    var_scalar = var_scalar + 5.0
    var_scalar_print = tf.Print(var_scalar, ['var_scalar:', var_scalar], summarize=100)
    # print('var_scalar', var_scalar)
    sim_score_scaled = similarity_scores * var_scalar

    y = tf.sigmoid(sim_score_scaled)
    loss = tf.losses.log_loss(
        label1, y, sample_weight1, epsilon=1e-10,
        reduction=tf.losses.Reduction.SUM)

    # 必须按顺序返回(loss, y, label, sample_weight)四元组
    graph_state = kwargs.get('graph_state', None)
    interests = []
    for i in range(interest_capsule.shape[1]):
        one_int = tf.gather(interest_capsule, indices=[i], axis=1)      # (batch_sz, 1, dim)
        interests.append(tf.reshape(one_int, [-1, output_emb_dim]))     # (batch_sz, dim)
    if graph_state == graph_state_helper('PREDICT', 'user_on_predict_cap1'):
        return [(None, interests[0], None, None)]
    elif graph_state == graph_state_helper('PREDICT', 'user_on_predict_cap2'):
        return [(None, interests[1], None, None)]
    elif graph_state == graph_state_helper('PREDICT', 'user_on_predict_cap3'):
        return [(None, interests[2], None, None)]
    elif graph_state == graph_state_helper('PREDICT', 'user_on_predict_cap4'):
        return [(None, interests[3], None, None)]
    elif graph_state == graph_state_helper('PREDICT', 'item_on_predict'):
        return [(None, normalize_item_fc_out, None, None)]      # (batch_sz, dim)
    else:
        return [(loss, y, label1, sample_weight1)]


if __name__ == '__main__':
    m = build_model()
    basename = os.path.basename(__file__).rsplit('.', 1)[0]
    dst_dir = './output_models'
    tfmlx.save(dst_dir + '/%s' % basename)
    model_def = tfmlx.get_model()
    tf_backend_op = model_def.graph.ops[-1]
    from tensorflow.core.protobuf.meta_graph_pb2 import MetaGraphDef

    meta_graph = MetaGraphDef()
    meta_graph.ParseFromString(tf_backend_op.tf_backend_attr.graph_attrs[0].graph_def)
    with open('./output_models/%s.graph.pb' % basename, 'wb') as fp:
        fp.write(meta_graph.graph_def.SerializeToString())