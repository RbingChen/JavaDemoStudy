package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  2022 - 04 - 05 13:25
 *  注意长度相同
 * */
public class P30 {
    public static List<Integer> findSubstring(String s, String[] words) {

        Map<String,Integer> map = new HashMap();
        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(int i = 0;i+totalLen<=s.length();i++){
            Map<String,Integer> map2 = new HashMap();
            String subStr = s.substring(i,i+totalLen);
            for(int num = 0;num+wordLen<=subStr.length();){
                String str = subStr.substring(num,num+wordLen);
                map2.put(str,map2.getOrDefault(str,0)+1);
                num = num + wordLen;
            }

            if(map.equals(map2)){
               result.add(i);
            }
        }
        return result;
    }
    public static List<Integer> findSubstringV2(String s, String[] words) {

        Map<String,Integer> map = new HashMap();
        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        int totalLen = s.length();
        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(int i = 0;i< wordLen;i++){
            int left = i,right=i,count=0;
            Map<String,Integer> tmpMap = new HashMap();
            while(right+wordLen< totalLen){
                String w = s.substring(right,right+wordLen);
                tmpMap.put(w,tmpMap.getOrDefault(w,0)+1);
                right +=wordLen;
                count++;
                while(tmpMap.getOrDefault(w,0) > map.getOrDefault(w,0)){
                    String w2 = s.substring(left,left+wordLen);
                    count--;
                    tmpMap.put(w2,tmpMap.getOrDefault(w2,0)-1);
                    left +=wordLen;
                }
                if(count == words.length) result.add(left);
            }
        }
        return result;
    }

    public static void main(String args[]){

//        String strs[]=new String[]{"bar", "foo", "the"};
//        for(Integer i : findSubstringV2("barfoofoobarthefoobarman",strs)){
//            System.out.print(i+" ");
//        }
        String t2= "wordgoodgoodgoodbestword";
        String strs2[]=new String[]{"word","good","best","good"};

        for(Integer i : findSubstring(t2,strs2)){
            System.out.print(i+" ");
        }

    }
}
