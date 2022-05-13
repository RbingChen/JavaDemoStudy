package com.nextwork.sword2offer;

public class SP14 {
    public int cuttingRope(int n) {
        int dp[] = new int[n+1];
        dp[2]=1;
        dp[1]=1;

        for(int i=3;i<=n;i++){
            for(int cut=2;cut<i;cut++ ){
                //dp[i] = Math.max((i-cut)*cut,Math.max(dp[i-cut]*dp[cut],dp[i]));
                int s1 = (i-cut)*cut;
                int s2 = dp[i-cut]*cut;
                int s3 = dp[cut]*(i-cut);
                int s4 = dp[i-cut]*dp[cut];

                dp[i] = Math.max(dp[i],Math.max(Math.max(s1,s2),Math.max(s3,s4)));
            }
        }
        return dp[n];

    }
    public static void main(String args[]){
        SP14 sp14 = new SP14();
        System.out.println(sp14.cuttingRope(5));
    }
}
