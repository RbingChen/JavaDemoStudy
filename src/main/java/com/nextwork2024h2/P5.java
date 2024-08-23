package com.nextwork2024h2;

public class P5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        int res = 1;
        String ret = s.substring(0,1);
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i==0) {
                    dp[j][j]=true;
                    continue;
                }
                if(j-i>=0 && i==1 && s.charAt(j) == s.charAt(j-i)){
                    dp[j][j-i] = true;
                    ret = s.substring(j-i,j+1);
                    continue;
                }
                if(j-i>=0 && s.charAt(j) == s.charAt(j-i) && j-1>=0 &&dp[j-1][j-i+1]){
                    dp[j][j-i] = true;
                    if(j-i+1>res){
                        res = j-i+1;
                        ret = s.substring(j-i,j+1);
                    }
                }
            }
        }
        return ret;
    }
    public static void main(String args[]){
        String s = "bb";
        P5 p5 = new P5();
        System.out.println(p5.longestPalindrome(s));
    }
}
