package com.cimon.rescy;

import java.text.ParseException;
import java.util.Calendar;

public class TestDate {
    public static void main(String args[]) throws ParseException {

        /*String end_date = "2020-01-19";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = simpleDateFormat.parse(end_date);
        Date beginDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        long diffDate = (endDate.getTime() - beginDate.getTime())/(1000*3600*24);

        System.out.println(diffDate);*/
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.HOUR_OF_DAY));

        String str="DAODIAN_ITEM_1DAY_1WEEK_CLICKPV_RATIO\t,\nDAODIAN_ITEM_1DAY_1WEEK_ORDERPV_RATIO\t,\nDAODIAN_ITEM_7DAY_1WEEK_CLICKPV_RATIO\t,\nDAODIAN_ITEM_7DAY_1WEEK_ORDERPV_RATIO\t,\nDAODIAN_ITEM_30DAY_1WEEK_CLICKPV_RATIO\t,\nDAODIAN_ITEM_30DAY_1WEEK_ORDERPV_RATIO\t,\nDAODIAN_ITEM_1DAY_2WEEK_CLICKPV_RATIO\t";
        String[] strArr = str.split(",");

        for(String t : strArr){
            System.out.print(t.trim()+" ");
        }
        for(String t : strArr){
            System.out.print(t+" ");
        }

    }
}
