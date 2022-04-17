package com.nextwork.leetcode;
/**
 * 2022-04-12 17:00
 * */
public class P64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        if(m==1 && n==1) return grid[0][0];
        int dp[][] = new int[m][n];

        dp[0][0] = grid[0][0];
        for(int i=1;i<m;i++)
            dp[i][0] = grid[i][0]+dp[i-1][0];

        for(int i=1;i<n;i++)
            dp[0][i] = grid[0][i]+dp[0][i-1];

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = grid[i][j]+ Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String args[]){
        int t[][] = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int t2[][] = new int[][]{{1,2,3},{4,5,6}};
        P64 p64 = new P64();
        System.out.println(p64.minPathSum(t));
        System.out.println(p64.minPathSum(t2));
    }
}
