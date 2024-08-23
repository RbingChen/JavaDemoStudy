package com.nextwork2024h2;

import java.util.*;

public class P3 {
    public int lengthOfLongestSubstring(String s) {
      Set<Character> set = new HashSet();
      int left = 0,right=0;
      int maxLen = 0;
      while(right<s.length()){
          while(set.contains(s.charAt(right))){
              set.remove(s.charAt(left++));
          }
          set.add(s.charAt(right));
          maxLen= Math.max(maxLen,right-left);
      }
      return maxLen;
    }
    public static void main(String args[]){

    }
}
