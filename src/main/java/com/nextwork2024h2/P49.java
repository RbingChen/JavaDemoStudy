package com.nextwork2024h2;
import java.util.*;
/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
示例 1:
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

示例 2:
输入: strs = [""]
输出: [[""]]

示例 3:
输入: strs = ["a"]
输出: [["a"]]
*/

public class P49 {
    public List<List<String>> groupAnagrams2(String[] strs){
        List<List<String>> ret = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i =0;i<strs.length;i++){
            char tc[] = strs[i].toCharArray();
            Arrays.sort(tc);
            String tmp = String.valueOf(tc);
            if(map.containsKey(tmp)){
                map.get(tmp).add(strs[i]);
            }else{
                map.put(tmp,new ArrayList<String>());
                map.get(tmp).add(strs[i]);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        boolean flag [] =  new boolean[strs.length];
        String tmp[] = new String[strs.length];
        for(int i=0;i<strs.length;i++){
            char tc[] = strs[i].toCharArray();
            Arrays.sort(tc);
            tmp[i] = String.valueOf(tc);
            System.out.println(tmp[i]);
        }
        for(int i=0; i<strs.length; i++){
            if(flag[i]) continue;
            List<String> rt = new ArrayList<>();
            rt.add(strs[i]);
            flag[i] = true;
            for(int j=1;j<strs.length;j++){
                if(flag[j]==false && tmp[j].equals(tmp[i])){  // 用equals
                    rt.add(strs[j]);
                    flag[j] = true;
                }
            }
            ret.add(rt);
        }
        return ret ;
    }
    public static void main(String args[]){
        String strs [] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        P49 p49 = new P49();
        p49.groupAnagrams(strs);
    }

}
