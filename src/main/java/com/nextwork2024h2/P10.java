package com.nextwork2024h2;

public class P10 {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(p.charAt(j)=='*'){
                     if ((j-1>0) && (p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i))){
                        dp[i+1][j+1] = dp[i][j - 1];
                    }else{
                         dp[i+1][j+1] = false;
                     }
                } else{
                     if(p.charAt(i)==s.charAt(j)){
                         dp[i+1][j+1] = dp[i-1][j-1];
                     }else{
                         dp[i+1][j+1] = false;
                     }
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String args[]){

    }
}
