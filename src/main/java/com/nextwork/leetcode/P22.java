package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * */
public class P22 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backString(n,n,result,"");
        return result;
    }
    public static void backString(int left ,int right,List<String>result,String parent){
        if(left>right || left < 0 || right < 0 )
            return;
        if(left==0 && right==0){
            result.add(parent);
        }else {
            backString(left - 1, right, result, parent + "(");
            backString(left, right - 1, result, parent + ")");
        }
    }

    public static void main(String args[]){
        List<String> result = generateParenthesis(3);
        for(String str : result){
            System.out.println(str);
        }
    }

}
