package com.nextwork.leetcode;

public class P63 {
    int count = 0;
    public int uniquePaths(int m, int n) {
        boolean status[][] = new boolean[m][n];
        count=0;
        search(0,0,status,m,n);
        return count;
    }
    public void search(int i, int j,boolean status[][],int m,int n){
        if(i>= m) return;
        if(j>= n) return;

        if(i==m-1 && j==n-1){
            count++;
            return;
        }else{

            if(i+1<m && !status[i+1][j]){
                status[i+1][j] = true;
                search(i+1,j,status,m,n);
                status[i+1][j] = false;
            }
            if(j+1<n && !status[i][j+1]){
                status[i][j+1] = true;
                search(i,j+1,status,m,n);
                status[i][j+1] = false;
            }

        }
    }
    public int uniquePathsV2(int m, int n) {
        int dp [][] = new int[m][n];
        dp[0][0] = 0;
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) return 0;
        int dp [][] = new int[m][n];
        dp[0][0] = 1;
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]!=1)
                dp[i][0] = dp[i-1][0];
        }
        for(int j=1;j<n;j++){
            if(obstacleGrid[0][j]!=1)
                dp[0][j] = dp[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1)
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String args[]) {
        P63 p62 = new P63();
        int ob[][] = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(p62.uniquePathsWithObstacles(ob));

    }
}
