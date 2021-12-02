package leetcode;

import java.util.Calendar;

public class p27 {
    public static int removeDuplicates(int[] nums) {

        if(nums.length<=1){
            return nums.length;
        }
        int i=0;
        int j=i+1;
        int count=1;
        for(;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                count++;
                i=j;
            }
        }
        return count;
    }
    public static void main(String args[]){
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        System.out.println(hour + "  "+min);
        String case_ ="mt_waimai_y_n:24.15,v4_page_name_diancai_3_day:1,mt_waimai_q_p:101.25,mt_waimai_hy_d:9.4,mt_waimai_hm_p:155.3,mt_waimai_hm_n:1.52,mt_waimai_q_q:4.04,mt_waimai_hy_a:770.02,消费类型:1,locate_city_id_cnt:1,mt_waimai_hm_q:1.52,mt_waimai_y_q:24.15,mt_waimai_y_p:65,v4_page_name_liebiao_ye_7_day:1,mt_waimai_q_d:3.91,mt_waimai_hy_p:75.1,v4_page_name_mendian_7_day:3,mt_movie_hy_n:0.36,v4_page_name_word_no_order_7_day:0.63,mt_waimai_hy_n:10.25,本科以上:1,丽人:0.0852,mt_waimai_m_d:1.82,mt_waimai_q_a:408.56,mt_waimai_hy_q:10.25,mt_waimai_m_p:149.59,mt_waimai_q_n:4.04,mt_waimai_y_d:21.74,mt_waimai_m_q:1.82,mt_movie_hy_q:0.76,mt_waimai_y_a:1569.54,运动健身:0.00163,mt_waimai_m_n:1.82,v4_page_name_shouyintai_14_day:2,mt_movie_hy_p:30.23,旅游:0.85257,v4_page_name_dingdan_ye_7_day:3,mt_legwork_w_p:8,shift_cnt_h500:20,v4_page_name_diancai_14_day:3,已结婚:1,v4_page_name_shouyintai_7_day:2,休闲娱乐:0.5188,收入水平=1:1,v4_page_name_dingdan_ye_14_day:3,v4_page_name_dingdan_xiangqing_3_day:1,app_com.zhihu.android:1,app_com.liulishuo.engzo:1,mt_waimai_hm_d:1.52,v4_page_name_tuangou_shouye_7_day:4,v4_page_name_waimai_14_day:4,mt_waimai_hm_a:235.85,宅男宅女:1,v4_page_name_tuangou_3_day:1,mt_legwork_hy_p:8,v4_page_name_liebiao_ye_14_day:1,mt_legwork_hy_q:0.09,mt_legwork_hy_n:0.09,app_com.huawei.KoBackup:1,v4_page_name_tuangou_shouye_14_day:5,v4_page_name_shouyintai_3_day:1,餐饮:6.35011,性别=女:1,mt_legwork_hm_p:8,mt_movie_y_p:43.73,mt_legwork_hy_d:0.09,mt_movie_y_n:0.96,v4_page_name_word_have_order_7_day:0.37,mt_legwork_hy_a:0.73,mt_movie_y_q:2.16,v4_page_name_shousuo_3_day:1,爱车:0.00888,常驻城市等级=B:1,v4_page_name_shousuo_14_day:2,shift_cnt_h100:20,v4_page_name_zidong_14_day:1,年龄段=3:1,othercity_buy_mt_waimai:1,app_com.sankuai.meituan:1,mt_group_hm_a:0.01,有车:1,电影演出赛事:0.01323,v4_page_name_diancai_7_day:3,mt_group_w_p:37,v4_page_name_dingdan_ye_3_day:1,app_me.ele:1,v4_page_name_tuangou_shouye_3_day:1,v4_page_name_dingdan_xiangqing_7_day:2,app_com.babytree.apps.pregnancy:1,团购敏感度:0.04808,mt_waimai_w_p:161.12,mt_waimai_w_n:1.08,v4_page_name_dingdan_14_day:3,shift_cnt_h50:20,mt_group_hy_q:12.85,mt_group_hy_p:47.99,v4_page_name_dingdan_xiangqing_14_day:2,mt_group_hy_n:12.6,mt_legwork_q_a:0.07,近一周活跃天数:4,mt_waimai_w_q:1.08,mt_legwork_q_d:0.01,v4_page_name_word_have_order_3_day:0.402,mt_group_m_a:1.09,v4_page_name_tuangou_14_day:5,酒店:0.04823,mt_group_hy_a:616.68,app_com.xiaomi.smarthome:1,mt_group_q_d:2.04,v4_page_name_waimai_3_day:1,mt_group_hm_p:36.99,mt_waimai_w_d:1.08,mt_group_hy_d:8.93,mt_group_q_a:130.31,mt_waimai_w_a:174.72,mt_group_m_d:0.03,v4_page_name_rongqi_14_day:2,mt_legwork_y_n:0.3,come_back_index:1,app_com.eg.android.AlipayGphone:1,mt_legwork_y_p:8,mt_legwork_y_q:0.3,mt_movie_m_p:23,mt_movie_y_d:0.54,白领:1,mt_movie_y_a:94.54,mt_movie_q_p:23.67,mt_movie_q_n:0.06,v4_page_name_zidong_7_day:1,mt_movie_q_q:0.12,first_hotel_used_hb_1:1,mt_legwork_y_a:2.41,常驻城市=太原:1,shift_cnt_y50:25,mt_legwork_m_p:8,mt_legwork_y_d:0.3,mt_legwork_q_n:0.01,mt_legwork_q_p:8,v4_page_name_waimai_dingdan_3_day:1,mt_legwork_q_q:0.01,mt_movie_q_d:0.03,mt_movie_q_a:2.91,app_com.wuba:1,家装:0.0082,v4_page_name_rongqi_3_day:1,v4_page_name_mendian_3_day:1,app_com.ss.android.article.news:1,购物:0.00727,app_com.huawei.hifolder:1,lastweek_buy_mt_waimai:1,mt_movie_w_p:23,生活服务:0.00411,近一月活跃天数:6,v4_page_name_dingdan_7_day:3,v4_page_name_waimai_7_day:3,v4_page_name_dingdan_3_day:1,v4_page_name_word_no_order_3_day:0.598,shift_cnt_y100:25,mt_group_y_d:19.74,app_com.huawei.wifiprobqeservice:1,v4_page_name_tuangou_7_day:4,mt_group_m_n:0.03,v4_page_name_shousuo_7_day:2,mt_group_m_q:0.03,mt_group_m_p:37.14,v4_page_name_mendian_14_day:3,shift_cnt_y500:25,mt_group_y_a:1412.9,app_com.booking:1,hongbao_ratio:0.5,v4_page_name_waimai_dingdan_14_day:2,app_com.Qunar:1,结婚:0.36339,mt_movie_hm_p:23,mt_waimai_m_a:271.6,mt_movie_hy_d:0.19,mt_movie_hy_a:22.94,mt_group_q_n:2.85,mt_group_q_q:2.91,v4_page_name_zidong_3_day:1,mt_group_q_p:44.84,v4_page_name_waimai_dingdan_7_day:2,v4_page_name_rongqi_7_day:2,page_city_id_cnt:1,mt_group_y_p:49.99,mt_group_y_q:28.26,mt_group_y_n:27.76,app_com.UCMobile:1,团购消费水平:98,app_com.mt.mtxx.mtxx:1,app_tv.danmaku.bili:1";
        System.out.println(case_.split(",").length);
    }
}
