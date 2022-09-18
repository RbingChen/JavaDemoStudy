package com.nextwork.leetcode;

import java.util.Arrays;

public class P188 {
    public int maxProfit(int k, int[] prices) {
        int t = prices.length;
        if(t<=1) return 0;
        k = Math.min(k,t/2);
        int buy[][] = new int [t][k+1];
        int sell[][] = new int[t][k+1];

        //表示第0天 发生 第 x 次 交易
        for(int i=1;i<=k;i++){
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE/2;
        }
        //
        for(int i=0;i<t;i++){
            sell[i][0] = 0;buy[i][0] = 0;
        }
        buy[0][1] = -prices[0];
        for(int i=1;i<t;i++){
            for(int j=1;j<=k;j++){
                buy[i][j] = Math.max(buy[i-1][j],sell[i-1][j-1]-prices[i]);
                sell[i][j] = Math.max(sell[i-1][j],buy[i-1][j]+prices[i]);
            }
        }
        return Arrays.stream(sell[t - 1]).max().getAsInt();
    }

    public static void main(String args[]){
      int arr[] = new int[]{3,2,6,5,0,3};
      int arr2[] = new int[]{2,4,1};
      P188 p188 = new P188();
      System.out.println(p188.maxProfit(2,arr2));
        System.out.println(p188.maxProfit(2,arr));
    }

}
