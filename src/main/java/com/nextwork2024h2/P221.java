package com.nextwork2024h2;

public class P221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length,m = matrix[0].length;

        int dp[][] = new int[n][m];
        int res =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    if(matrix[0][j]=='1') dp[0][j]=1;
                }else if(j==0){
                    if(matrix[i][0]=='1') dp[i][0]=1;
                }else{
                    if(matrix[i][j]=='1'){
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;

                    }
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res*res;
    }
    public static void main(String args[]){
       char mat [][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
       P221 p221 = new P221();
       System.out.println(p221.maximalSquare(mat));
    }
}
