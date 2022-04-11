package com.nextwork.leetcode;

import java.util.List;

/*
 *  2022 - 04 - 10 21:32
 */
public class P36 {
    public boolean isValidSudoku(char[][] board) {
        int row[][] = new int[9][9];
        int col[][] = new int[9][9];
        int box[][][] = new int[3][3][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int t = board[i][j] - '1';

                row[i][t]++;
                col[j][t]++;
                box[i/3][j/3][t]++;
                if(row[i][t]>1 || col[j][t] >1 || box[i/3][j/3][t] >1 ){
                    return false;
                }
            }

        }
        return true;
    }
    public static void main(String args[]){

    }

}
