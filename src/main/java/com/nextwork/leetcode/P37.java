package com.nextwork.leetcode;
/*
 *  2022 - 04 - 10 22:02
 */

import java.util.ArrayList;
import java.util.List;

public class P37 {
    boolean row[][] = new boolean[9][9];
    boolean col[][] = new boolean[9][9];
    boolean box[][][] = new boolean[3][3][9];
    boolean valid = false;
    class Pair{
        int v;
        int w;
        Pair(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    List<Pair> leftSpace = new ArrayList();
    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') {
                    leftSpace.add(new Pair(i,j));
                }else {
                    int t = board[i][j] - '1';
                    row[i][t] = true;
                    col[j][t] = true;
                    box[i/3][j/3][t] = true;
                }
            }
        }
        dfs(board,0);
    }
    public void dfs(char[][] board,int pos){
        if(pos == leftSpace.size()){
            valid = true;
            return;
        }
        Pair pair = leftSpace.get(pos);
        int i = pair.v ,j = pair.w;
        for(int d = 0;d < 9; d++){
            if(!row[i][d] && !col[j][d] && !box[i/3][j/3][d] &&!valid){
                row[i][d] = col[j][d] = box[i/3][j/3][d] = true;
                board[i][j]= (char)(d+'0'+1);
                dfs(board,pos+1);
                row[i][d] = col[j][d] = box[i/3][j/3][d] = false;

            }
        }
    }
}
