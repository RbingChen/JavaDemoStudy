package com.nextwork.leetcode;

import java.util.List;

public class P79 {
    int direction[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        int n = board.length,m = board[0].length;
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean visited[][] = new boolean[n][m];
                    visited[i][j] = true;
                    if(help(board,visited,word,n,m,i,j,1)) return true;
                }
            }
        }
        return false;
    }
    public boolean help(char[][] board,boolean [][]visited,String word,int n,int m,int i ,int j,int begin ){
        if(begin==word.length()) return true;
        for(int k=0;k<4;k++){
            int newi = i+direction[k][0];
            int newj = j+direction[k][1];
            if(newi<n && newj<m && newi>=0 && newj>=0){
                char ch =board[newi][newj];
                char ch2 = word.charAt(begin);
                if(!visited[newi][newj] && ch==ch2){
                    visited[newi][newj] = true;
                    if(help(board,visited,word,n,m,newi,newj,begin+1)) return true;
                    visited[newi][newj] = false;
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        P79 p79 = new P79();
        char board[][] = new char[][]{{'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};
        String word = "ABCCED";
        String word2 = "ABCB";


        System.out.println(p79.exist(board,word2));
    }
}
