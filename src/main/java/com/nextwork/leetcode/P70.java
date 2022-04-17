package com.nextwork.leetcode;

public class P70 {
    int count=0;
    public int climbStairs(int n) {
        backTrack(n);
        return count;
    }
    public void backTrack(int left){
       if(left==0){
           count+=1;
           return;
       }else if(left>0){
           backTrack(left-1);
           backTrack(left-2);
       }
    }
    public int climbStairsV2(int n){
        int dp[] = new int[n+1];
        if(n<=2) return n;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]){
        P70 p70 = new P70();
        System.out.println(p70.climbStairs(3));
    }
}
