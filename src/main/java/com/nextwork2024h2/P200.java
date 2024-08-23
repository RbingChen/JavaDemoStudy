package com.nextwork2024h2;
/*
* https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/?envType=study-plan-v2&envId=top-100-liked
* */
public class P200 {
    public int numIslands(char[][] grid) {
        int m = grid.length,n = grid[0].length;
        boolean flag[][] = new boolean[m][n];
        int cnt = 0;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && flag[i][j]==false){
                    cnt++;
                    dfs(grid,flag,i,j,m,n);
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] grid,boolean flag[][],int i,int j,int m,int n){
        if(i<0 ||i >=m ||j<0 || j>=n) return;
        if(grid[i][j]=='0')return ;
        if(flag[i][j]==true) return;

        flag[i][j] = true;

        dfs(grid,flag,i,j+1,m,n);

        dfs(grid,flag,i+1,j,m,n);

        dfs(grid,flag,i-1,j,m,n);

        dfs(grid,flag,i,j-1,m,n);


    }

}
