package com.cimon.tool.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
    public static String getSlideMinute(int minuteOfDay){
        String slideMinute ="";
        for(int i=-15;i<=15;i++){
            if(slideMinute.length()==0) {
                slideMinute+=String.valueOf((minuteOfDay+i+1439)%1440);
            }else{
                slideMinute+=","+String.valueOf((minuteOfDay+i+1439)%1440);
            }
        }
        return slideMinute;
    }
    public static void main(String args[]){
        long sample_time = 1627533153748L;
        Date date1 = new  Date(sample_time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(" haha " +simpleDateFormat.format(sample_time));

        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(2%3);
        System.out.println((1627537050459L-1578179845000L)/1000%(24*60*60));
//        System.out.println(getSlideMinute(calendar.get(Calendar.HOUR_OF_DAY)*60+calendar.get(Calendar.MINUTE)));
//        System.out.println(getSlideMinute(1439));
//        System.out.println(getSlideMinute(0));
//        System.out.println(getSlideMinute(1));


    }
}
