package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-04-11 10：10
 * 皇后的走法是：可以横直斜走，格数不限。因此要求皇后彼此之间不能相互攻击，
 * 等价于要求任何两个皇后都不能在同一行、同一列以及同一条斜线上。
 * */
public class P51 {
    List<List<String>> result = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        if(n==0) return result;
        char[][] tu = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tu[i][j]='.';
            }
        }
        backTrack(tu,n,0,0);
        return result;
    }
    public void backTrack(char[][] tu,int n,int begin,int count){
        if(begin==n && count==n){
            List<String> lt = new ArrayList<>();
            for(int i=0;i<n;i++){
                String t="";
                for(int j=0;j<n;j++){
                    t+=tu[i][j];
                }
                lt.add(t);
            }
            result.add(lt);
            return;
        }else {

                for (int j = 0; j < n; j++) {
                    if (check(tu, begin, j, n)) {
                        tu[begin][j] = 'Q';
                        backTrack(tu, n, begin + 1, count + 1);
                        tu[begin][j] = '.';
                    }
                }

        }
    }
    public boolean check(char[][] list,int i ,int j,int n){
      for(int t=0;t<n;t++) {
          // 检测列
          if (list[t][j] == 'Q') return false;
      }
      for(int t=0;t<n;t++) {
            // 检测列
            if (list[i][t] == 'Q') return false;
      }
      for(int t=0;t<n;t++) {
            // 检测列
            if (list[t][j] == 'Q') return false;
      }
      int t_i =i,t_j=j;

      while(i>=0 && j>=0 && j<n && i<n){
          if(list[i][j]=='Q') return false;
          i--;j++;
      }
      i= t_i;
      j= t_j;
      while(i>=0 && j>=0 && j<n && i<n){
            if(list[i][j]=='Q') return false;
            i--;j--;
      }
        i= t_i;
        j= t_j;
      while(i>=0 && j>=0 && j<n && i<n){
            if(list[i][j]=='Q') return false;
            i++;j--;
      }
        i= t_i;
        j= t_j;
        while(i>=0 && j>=0 && j<n && i<n){
            if(list[i][j]=='Q') return false;
            i++;j++;
        }
       return true;
    }
    public static void main(String args[]){
        P51 p51 = new P51();
        List<List<String>> t = p51.solveNQueens(4);
        p51.Print(t);
    }
    void Print( List<List<String>> lt){
        for(List<String> t : lt){
            for(String i : t){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
