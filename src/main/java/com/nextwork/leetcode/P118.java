package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P118 {
    public List<List<Integer>> generate(int numRows) {
        int curRow = 1;
        List<List<Integer>> res = new ArrayList();
        while(curRow<=numRows){
            List<Integer> lt = new ArrayList();
            for(int i=0;i<curRow;i++){
                if(i==0 || i ==curRow-1){
                    lt.add(1);
                }else{
                    int a = res.get(curRow-1).get(i-1);
                    int b = res.get(curRow-1).get(i);
                    lt.add(a+b);
                }
            }
            res.add(lt);
            curRow++;
        }
        return res;
    }
    public static void main(String args[]){
        P118 p118 = new P118();
        System.out.println(p118.generate(5));
    }
}
