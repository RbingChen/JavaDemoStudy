package com.next2024;
import java.util.*;

public class p49 {

    public List<List<String>> groupAnagrams(String[] strs) {
     List<List<String>> list = new ArrayList<>();
     if(strs.length<=1){
         List<String> tmp = new ArrayList<>();
         if(strs.length==1) {
             tmp.add(strs[0]);
             list.add(tmp);
         }
         return list;
     }

     Map<String,List<String>> map = new HashMap<>();
    for(String str:strs){
         char[] chars = str.toCharArray();
         Arrays.sort(chars);
         String key = String.valueOf(chars);
         if(map.containsKey(key)){
             map.get(key).add(str);
         }else{
             List<String> tmp = new ArrayList<>();
             tmp.add(str);
             map.put(key,tmp);
         }
     }
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            list.add(entry.getValue());
        }

     return list;
    }
    public static void main(String args[]){

    }

}
