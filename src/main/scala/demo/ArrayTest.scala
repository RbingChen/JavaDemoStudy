package demo

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

object ArrayTest {
  def get_new_label(bu_type:String,label:String): String={
    println(bu_type+" :  "+label)
    val bu_array = Array("DEAL_GROUP","DEAL_WAIMAI","POI_BNB","POI_GROUP","POI_HOTEL2","POI_LVYOU","POI_WAIMAI","POI_XIUYU","PREPAY_DAOZONG_YIMEI","SPU_SHANGOU","PRODUCT","COOKBOOK","COMMENT","NOTE",
      "TOPIC_DAOCAN","TOPIC_DISCOUNT","TOPIC_I2I","TOPIC_NLP","TOPIC_RECSYS","TOPIC_TIANSHU","TRAFFIC")
    val click_label = Array(11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)
    var i = 0
    for(i <- 0 to click_label.length-1){
      //print(i)
      if(bu_array(i).equals(bu_type)) {

        if (label.equals("1"))
          return click_label(i).toString


        if (label.equals("3"))
          return (click_label(i)+20).toString

        if (label.equals("5"))
          return (click_label(i) + 40).toString
      }
    }
    label
  }
  def generate_label_parse(): Unit ={
    val bu_array = Array("DEAL_GROUP","DEAL_WAIMAI","POI_BNB","POI_GROUP","POI_HOTEL2","POI_LVYOU","POI_WAIMAI","POI_XIUYU","PREPAY_DAOZONG_YIMEI","SPU_SHANGOU","PRODUCT","COOKBOOK","COMMENT","NOTE",
      "TOPIC_DAOCAN","TOPIC_DISCOUNT","TOPIC_I2I","TOPIC_NLP","TOPIC_RECSYS","TOPIC_TIANSHU","TRAFFIC")
    val click_label = Array(11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)
    var i = 0
    var click_label_parse=""
    var order_label_parse=""
    var pay_label_parse=""
    for(i <- 0 to click_label.length-1){
       if(!bu_array(i).equals("DELA_WAIMAI") && !bu_array(i).equals("POI_WAIMAI")) {
         click_label_parse = click_label_parse+";"+click_label(i).toString()+":1:5"
         order_label_parse = order_label_parse+";"+(click_label(i)+20).toString()+":1:7"
         pay_label_parse = pay_label_parse+";"+ (click_label(i)+40).toString()+":1:10"
       } else{
         click_label_parse = click_label_parse+";"+click_label(i).toString()+":1:1"
         order_label_parse = order_label_parse+";"+(click_label(i)+20).toString()+":1:1"
         pay_label_parse = pay_label_parse+";"+ (click_label(i)+40).toString()+":1:1"
       }
    }
    println(click_label_parse)
    println(order_label_parse)
    println(pay_label_parse)
  }

  def generate_label_parse_v2(): Unit ={
    val bu_array = Array("DEAL_GROUP","DEAL_WAIMAI","POI_BNB","POI_GROUP","POI_HOTEL2","POI_LVYOU","POI_WAIMAI","POI_XIUYU","PREPAY_DAOZONG_YIMEI","SPU_SHANGOU","PRODUCT","COOKBOOK","COMMENT","NOTE",
      "TOPIC_DAOCAN","TOPIC_DISCOUNT","TOPIC_I2I","TOPIC_NLP","TOPIC_RECSYS","TOPIC_TIANSHU","TRAFFIC")
    val click_label = Array(11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)
    var i = 0
    var click_label_parse=""
    var order_label_parse=""
    var pay_label_parse=""
    val mid_bu =Array("DEAL_GROUP","POI_BNB","POI_GROUP","POI_HOTEL2","POI_LVYOU","POI_WAIMAI","POI_XIUYU","PREPAY_DAOZONG_YIMEI","SPU_SHANGOU","PRODUCT","COOKBOOK","COMMENT","NOTE",
      "TOPIC_DAOCAN","TOPIC_DISCOUNT","TOPIC_I2I","TOPIC_NLP","TOPIC_RECSYS","TOPIC_TIANSHU","TRAFFIC")

    for(i <- 0 to click_label.length-1){
      if(!bu_array(i).equals("DELA_WAIMAI") && !bu_array(i).equals("POI_WAIMAI")) {
        click_label_parse = click_label_parse+";"+click_label(i).toString()+":1:5"
        order_label_parse = order_label_parse+";"+(click_label(i)+20).toString()+":1:7"
        pay_label_parse = pay_label_parse+";"+ (click_label(i)+40).toString()+":1:10"
      } else{
        click_label_parse = click_label_parse+";"+click_label(i).toString()+":1:1"
        order_label_parse = order_label_parse+";"+(click_label(i)+20).toString()+":1:1"
        pay_label_parse = pay_label_parse+";"+ (click_label(i)+40).toString()+":1:1"
      }
    }
    println(click_label_parse)
    println(order_label_parse)
    println(pay_label_parse)
  }
  def load_data(
                r: String
               ) :String= {


      val line = r.split("\t")
      val key = line(0)
      val label_feature = line(1).split("\\s+")
      val label = label_feature(0)

      val feature = label_feature.slice(1,label_feature.length).mkString(" ")
      val bu_type = key.split("-")(1)
      val new_label = get_new_label(bu_type,label)
       println(new_label)
       key+"\t"+new_label+" "+feature

  }
  def tranTimeToString(tm:String): Unit ={
    val fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val tim = new Date(tm.toLong)
    val cal = Calendar.getInstance()
    cal.setTime(tim)
    println(cal.get(Calendar.HOUR_OF_DAY))
  }
  def main(args:Array[String]): Unit ={
    val str_ = "6c53ae26935ace2218bbb77e065e5207-POI_WAIMAI-123779535-Ranker_homepage_HpYidiXz20Q1NewBase-2542124185-1578541472000-1\t1 4611686018427387904:0.82617 4611686018427387906:0.13286 4611686018427387907:0.90709 4611686018427387909:0.06893 4611686018427387910:0.00799 4611686018427387912:0.52547 4611686018427387915:0.78721 4611686018427387916:0.17582 4611686018427387917:0.94505 4611686018427387918:9.9E-4 4611686018427387919:0.61738"
   // println(load_data(str_))
    //println(get_new_label("ddd","1"))
    tranTimeToString("1597732868000")
    val tt = "560b33d51cb7e099538d5616ad22639b-TOPIC_I2I-439612-Ranker_homepage_Hp20H2NewBase_20200727_continueExpoTest-378596681-1597051608000-1"
    println(tt.split("-")(5))
    generate_label_parse()
  }
}
