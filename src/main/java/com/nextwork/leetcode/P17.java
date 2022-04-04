package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P17 {
    static String params[]={"abc","def","ghi","jkl","mno","prqs","tuv","wxyz"};
    public static  List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0) return result;
        backString(digits,result,"");
        return result;
    }
    public static void backString(String digits,List<String> result,String res){
        if(digits.length()==0){
            result.add(res);
            return;
        }
        int t = digits.charAt(0) - '0'-2;
        if(digits.length()>1){
            digits = digits.substring(1);
        }else digits = "";
        String param = params[t];
        for(int i =0;i<param.length();i++){
            backString(digits,result,res+param.charAt(i));
        }

    }

    public static void main(String args[]){
        List<String> result = letterCombinations("23");
        for(String str : result){
            System.out.println(str);
        }
    }

}
