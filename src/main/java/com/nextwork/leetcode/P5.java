package com.nextwork.leetcode;
/**
 * 2022-03-31 21:36
 * 步长
 * 最长公共子串
 * */
public class P5 {
    public static String longestPalindrome(String s) {
       if(s.length()==0) return null;
       int len = s.length();
       int maxLen = 1;
       int begin = 0;
       boolean dp[][] = new boolean[len][len];
       for(int i =0;i<len;i++)
           dp[i][i] = true;
       char ch[] = s.toCharArray();
       for(int L=2; L <=len;L++){

           for(int i=0;i <len ;i++) {
               int j = i + L - 1;
               if (j >= len) break;
               if (ch[i] != ch[j]) {
                   dp[i][j] = false;
               } else {
                   if (j - i < 3)
                       dp[i][j] = true;
                   else dp[i][j] = dp[i + 1][j - 1];
               }
               if (dp[i][j] && j - i + 1 > maxLen) {
                   maxLen = j - i + 1;
                   begin = i;
               }
           }
       }
       return s.substring(begin,begin+maxLen);
    }
    public static void main(String args[]){
      System.out.println(longestPalindrome("babad"));
    }
}
