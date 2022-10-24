package demo

import scala.collection.mutable

object RecallVector {
  def main(args:Array[String]):Unit={
    val str = "34bd51eb387a871a7a41721c035d5003-POI_GROUP-1130361677-Ranker_homepage_Hp20H2NewBase_20210715_yxhelpv3-178058513-1660908833000-5-650-45\t-0.139455\t-0.084753\t0.566928\t-0.0812459\t0.338492\t-0.0180098\t-0.191394\t0.065032\t-0.0914733\t-0.0583077\t-0.0610552\t-0.0819051\t0.00540265\t-0.00825753\t0.0906971\t0.531382\t-0.0736887\t0.102132\t-0.0939802\t-0.0444386\t0.068515\t-0.215825\t-0.094009\t-0.155499\t-0.110802\t0.111708\t-0.0504259\t-0.147279\t0.0194448\t-0.113953\t-0.0472383\t-0.0340677\t1"
    val  arr1 = str.split("\\s+")
    println(arr1.length)
    val  arr2 = arr1(0).split("-")
    println(arr2.length)

    //val argArr = Array("ttt:1233","122:333")
    //val map = parseArgs(argArr)

    val str2 = "-DEAL_GROUP-768217061----1\t\t1 4611686018427388057:-0.0684409 4611686018427388058:0.137085 4611686018427388059:0.576028"
    val str2Arr = str2.split("\\s+")
    val str2key = str2Arr(0).split("-")
    for(i <- 0 to str2key.length-1)
           println(i+":"+str2key(i))

    println(str2Arr.length)
    println(str2Arr.slice(2,str2Arr.length).mkString(" "))

  }

  def parseArgs(args: Array[String]): mutable.HashMap[String, String] = {
    println("args size:"+args.length)

    val rst = new mutable.HashMap[String, String]() { override def default(key: String) = "无参数传入"}
    for (a <- args) {
      val key_val = a.split(":")
      if (key_val.length >= 2) {
        if (rst.contains(key_val(0))){ // 为了解决hdfs正则化路径时Array变多个的问题
          val value = rst.get(key_val(0)).get
          val newValue = value + "," + key_val.splitAt(1)._2.mkString(":")
          rst += (key_val(0) -> newValue)
          println(key_val(0)+":"+newValue)
        }else{
          rst += (key_val(0) -> key_val.splitAt(1)._2.mkString(":"))
          println(key_val(0)+":"+key_val.splitAt(1)._2.mkString(":"))
        }


      }
    }
    rst
  }
}
