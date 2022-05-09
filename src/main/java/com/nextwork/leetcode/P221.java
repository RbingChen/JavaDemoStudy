package com.nextwork.leetcode;

public class P221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        int maxSquare = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    int step=1;
                    while(true){
                        boolean flag = true;
                        int newi = i+step,newj = j+step;
                        if(newi>=n || newj>=m) break;
                        for(int t=j;t<=newj;t++){
                            if(matrix[newi][t]!=1) flag=false;
                        }
                        if(!flag) break;
                        for(int t=i;t<=newi;t++){
                            if(matrix[t][newj]!=1) flag=false;
                        }
                        if(!flag) break;

                        maxSquare = Math.max(maxSquare,(step+1)*(step+1));
                        step++;

                    }

                }
            }
        }
        return maxSquare;
    }
    public static void main(String args[]){
        P221 p221 = new P221();

    }
}
