package caixirank;

public class BuWight {
    public static void  generate_label_parse_v0(){
        String[] bu_array = {"DEAL_GROUP","DEAL_WAIMAI","POI_BNB","POI_GROUP","POI_HOTEL2","POI_LVYOU","POI_WAIMAI","POI_XIUYU",
                "PREPAY_DAOZONG_YIMEI","SPU_SHANGOU","PRODUCT","COOKBOOK","COMMENT","NOTE",
                "TOPIC_DAOCAN","TOPIC_DISCOUNT","TOPIC_I2I","TOPIC_NLP","TOPIC_RECSYS","TOPIC_TIANSHU","TRAFFIC"};
        int[] click_label = {11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        String click_label_parse="";
        String order_label_parse="";
        String pay_label_parse="";
        int[] click_weight = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] order_weight = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        for(int i =0;i< click_label.length ;i++){

            click_label_parse = click_label_parse+";"+click_label[i]+":1:"+click_weight[i];
            order_label_parse = order_label_parse+";"+(click_label[i]+30)+":1:"+order_weight[i];
            pay_label_parse = pay_label_parse+";"+ (click_label[i]+60)+":1:"+order_weight[i];

        }
        System.out.println(click_label_parse);
        System.out.println(order_label_parse);
        System.out.println(pay_label_parse);
    }

    public static void  generate_label_parse_v2(){
        String[] bu_array = {"DEAL_GROUP","DEAL_WAIMAI","POI_BNB","POI_GROUP","POI_HOTEL2","POI_LVYOU","POI_WAIMAI","POI_XIUYU",
                "PREPAY_DAOZONG_YIMEI","SPU_SHANGOU","PRODUCT","COOKBOOK","COMMENT","NOTE",
                "TOPIC_DAOCAN","TOPIC_DISCOUNT","TOPIC_I2I","TOPIC_NLP","TOPIC_RECSYS","TOPIC_TIANSHU","TRAFFIC"};
        int[] click_label = {11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        String click_label_parse="";
        String order_label_parse="";
        String pay_label_parse="";
        int[] click_weight = {1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,5,5,5,5};
        int[] order_weight = {2,1,9,2,3,4,1,4,10,10,1,1,1,1,1,1,1,1,1,1,1};

        for(int i =0;i< click_label.length ;i++){

                click_label_parse = click_label_parse+";"+click_label[i]+":1:"+click_weight[i];
                order_label_parse = order_label_parse+";"+(click_label[i]+30)+":1:"+order_weight[i];
                pay_label_parse = pay_label_parse+";"+ (click_label[i]+60)+":1:"+order_weight[i];

        }
        System.out.println(click_label_parse);
        System.out.println(order_label_parse);
        System.out.println(pay_label_parse);
    }
    
    public static void main(String args[]){
        generate_label_parse_v0();
    }
}
