package com.nextwork.leetcode;

import java.util.List;

public class P79 {
    public boolean exist(char[][] board, String word) {
        int n = board.length,m=board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                boolean flag = check(board,visited,i,j,word,0);
                if(flag) return true;
            }
        }
        return true;
    }
    public boolean check(char[][] board,boolean[][] visited,int i ,int j,String word,int k){
        if(board[i][j]!=word.charAt(k)){
            return false;
        }else if(k==word.length()-1){
            return true;
        }
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean result = true;

        return false;
    }
    public static void main(String args[]){
        P79 p79 = new P79();
        char board[][] = new char[][]{{'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};
        String word = "ABCCED";

        System.out.println(p79.exist(board,word));
    }
}
