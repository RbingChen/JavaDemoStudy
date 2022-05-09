package com.nextwork.leetcode;

public class P91 {
    public int numDecodings(String s) {
        int len = s.length();
        if(len==0) return 0;
        int dp[] = new int[s.length()];
        char pre = s.charAt(0);
        if(len==1 && pre=='0') return 0;

        dp[0]=1;
        for(int i=1;i<len;i++){

            char ch = s.charAt(i);
            if(ch==0||pre==0) {
                if(i==1){
                    dp[i]=dp[i-1];
                }else{
                    dp[i] = dp[i-2];
                }
            }else{
                String tmp = s.substring(i-1,i+1);
                if("26".compareTo(tmp)>=0) dp[i]=dp[i-1]+1;
            }
            pre = ch;
        }
        return dp[len-1];

    }
    public static void main(String args[]){
        P91 p91 = new P91();
        System.out.println(p91.numDecodings("12"));
    }
}
