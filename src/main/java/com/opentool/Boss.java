//import org.apache.commons.lang3.StringUtils;
//
//import java.util.Arrays;
//import java.util.Comparator;userid orderid order_start_timestamp order_end_timestamp
//         第二单开始时间在， 上一个订单结束30天内。
//
//
// select  userid,
//         reorderUDF(concat_ws(";",collect_set(concat(orderid,"-","order_start_timestamp","-",order_end_timestamp ))))
// from  t.table group by userid
//
//
//  selct
//        userid,
//        sum(order_count) as reorder_total_count
//        from
//        (
//                select
//         userid,
//         if(datediff(t1.start_date - t0.end_date)<30
//            and datediff(t1.start_date - t0.end_date)>0 ,1,0) as order_count
//  from
//        (
//                select userid,order, start_date, end_date
//
// from t.table
//        )t0
//
//   inner join
//
//        (select userid,order as order1, start_date as start_date1, end_date  as end_date1
//from t.table
//        )t1 on t0.userid = t1.userid
//        )tt
//
// public class reorderUDF{
//
//    public double evaluate(String orderlist){
//        if(StringUtils.isEmpty(orderlist)) return 0.0;
//        String order[] = orderlist.split(";");
//        Arrays.sort(order, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String order1[] = o1.split("-");
//                String order2[] = o2.split("-");
//                return order1[1].compareTo(order2[1]);
//            }
//        }); // 订单id升序
//
//        for(int i=0; i< order.length;i++ ){
//            String order1[] = order[i].split("-");
//            for(int j=i+1;j<order.length;j++){
//                String order2[] = order
//            }
//        }
//
//    }
//    public boolean isLessThan30Day(String t1 ,String t2){
//        // yyyyMMdd
//        if(Integer.valueOf(t2) - Integer.valueOf(t1)<30) true;
//        return false;
//    }
//
// }




