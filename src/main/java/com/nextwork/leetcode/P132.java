package com.nextwork.leetcode;

public class P132 {
    public int minCut(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];

        for(int i=0;i<len;i++) dp[i][i] = true;

        for(int l=1;l<=len;l++){
            for(int i=0;i+l<len;i++){
                int j= i+l;
                if(l==1 && s.charAt(i)==s.charAt(j))dp[i][j] =true;
                else{
                    if(s.charAt(i)==s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                }
            }
        }

        int dpv1[] = new int[len];
        int ind = len-1,count=0;
        while(ind>=0){
            int i=0;
            for(;i<=ind;i++){
                if(dp[i][ind]==true) break;
            }
            ind=i-1;
            count++;
        }
        return count>0 ? count-1:0;
    }
    public static void main(String args[]){
        P132 p132 = new P132();
        System.out.println(p132.minCut("abbab"));
    }
}
