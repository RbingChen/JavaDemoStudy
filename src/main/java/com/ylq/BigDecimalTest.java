package com.ylq;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BigDecimalTest {
    public static void main(String args[]){
        String val = "123.4567";
        BigDecimal bd = new BigDecimal(val);

        bd.setScale(2, RoundingMode.FLOOR); // 返回的是一个新对象
        System.out.println(" demo1 : "+ bd.toString()); // bd是老对象

        /****/
        BigDecimal bd2 = bd.setScale(2, RoundingMode.FLOOR);
        System.out.println(" demo2 : "+bd2.toString());//新对象打印

        HashMap<List<Integer>,Integer> map = new HashMap();

        ArrayList<Integer> list = new ArrayList();
        list.hashCode();
        list.equals(list);
        list.add(1);list.add(2);
        map.put(list,2);


    }
}
