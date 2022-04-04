package com.nextwork.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022-03-30 20:56
 * map实现滑窗
 * */
public class P3 {
    public static int lengthOfLongestSubstring(String s) {
      int maxLen = 0;
      int left = 0;
      Map<Character,Integer> map = new HashMap();
      for(int i=0;i<s.length();i++){
          Character ch = s.charAt(i);
          if(map.containsKey(ch)){
              left = Math.max(left,map.get(ch)+1);
          }
          map.put(ch,i);
          maxLen = Math.max(maxLen,i - left+1);
      }

      return maxLen;
    }
    public static void main(String args[]){
       System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
