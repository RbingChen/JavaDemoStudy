package com.nextwork.leetcode;
/**
 * 2022-04-02 18:01
 *  搞不懂这个题
 * */
public class P10 {

    public boolean isMatch(String s, String p) {
       int m = s.length(), n = p.length();
       if(m==0&&n==0) return true;
       boolean dp[][] = new boolean[m+1][n+1];
       dp[0][0] = true;
       for(int i = 1;i <=m;i++){
           char cs = s.charAt(i-1);
           for(int j = 1;j <=n ;j++){
               char cp = p.charAt(j-1);
               if(cs == cp || cp=='.'){
                   dp[i][j] = dp[i-1][j-1];
               }else if(cp=='*'){
                   dp[i][j] = dp[i][j-2];
                   if(p.charAt(j-2)=='.' || p.charAt(j-2)==cs) {
                      dp[i][j] = dp[i][j-2] || dp[i-1][j];
                   }
               }
           }
       }
       return dp[m][n];

    }
    public  static void main(String args[]){

    }
}
