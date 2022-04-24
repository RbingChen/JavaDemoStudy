package com.nextwork.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P76 {

    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character,Integer> mapT =  new HashMap();

        Map<Character,Integer> mapS = new HashMap();
        for(char ch : t.toCharArray()){
            mapT.put(ch,mapT.getOrDefault(ch,0)+1);
        }

        int count = t.length();
        int left=-1;
        int right=0;
        int maxLen = Integer.MAX_VALUE;
        String res="";
        while(left<=right){

            if(count>0 && right<s.length()){
                char ch = s.charAt(right);
                if(mapT.containsKey(ch) ){
                    mapS.put(ch,mapS.getOrDefault(ch,0)+1);
                    if(mapS.get(ch)<= mapT.get(ch)) count--;
                }
                right++;
            }
            if(count==0){
                if(right-left-1<maxLen){
                    maxLen = right-left-1;
                    res = s.substring(left+1,right);
                }
                left++;
                char ch = s.charAt(left);
                if(mapT.containsKey(ch)){
                    mapS.put(ch,mapS.get(ch)-1);
                    if(mapS.get(ch)< mapT.get(ch)) count++;
                }
            }
            if(right==s.length() && count>0) break;
        }
        return res;
    }
    public static void main(String args[]){
        P76 p76 = new P76();
        //String s = "ADOBECODEBANC", t = "ABC";
        String s = "ab", t = "b";
        System.out.println(p76.minWindow(s,t));
        int ttt [] = new int[10];

    }
}
