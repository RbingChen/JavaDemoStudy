package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P301 {
    List<String> res ;
    public List<String> removeInvalidParentheses(String s) {
        res = new ArrayList();
        int  rp = 0,lp=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                lp++;
            }else if(s.charAt(i)==')'){
                if(lp==0){
                    rp++;
                }else{
                    lp--;
                }
            }
        }
        backTrack(s,lp,rp,0);
        return res;
    }

    public void backTrack(String str , int lp ,int rp,int begin){
        if(lp==0 && rp ==0 && isValid(str)){
            res.add(str);
            return;
        }
        for(int i=begin;i<str.length();i++){
            if (i != begin && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            if(lp+rp> str.length()-i) return;

            if(lp>0 && str.charAt(i)=='('){
                backTrack(str.substring(0,i)+str.substring(i+1),lp-1,rp,i);
            }
            if(rp>0 && str.charAt(i)==')'){
                backTrack(str.substring(0,i)+str.substring(i+1),lp,rp-1,i);
            }
        }
    }
    public boolean isValid(String str){
        int cnt =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                cnt++;
            }else if(str.charAt(i)==')'){
                cnt--;
                if(cnt<0) return false;
            }
        }
        return cnt==0;
    }
    public static void main(String args[]){
        P301 p301 = new P301();

        List<String> t = p301.removeInvalidParentheses("()())()");
        for(String str :t ){
            System.out.println(str);
        }
    }
}
