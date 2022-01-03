package com.cimon.leetcode;

import java.util.Scanner;

public class YcFive {
    public static void dfs(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 0;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    public static int findGroupNum(int grid [][]){
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numGroups = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == 1) {
                    ++numGroups;
                    dfs(grid, r, c);
                }
            }
        }
        return numGroups;
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int c = scan.nextInt();
        int[][] arr = new int[r][c];
        scan.nextLine();
        for(int i=0;i<r;i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        System.out.println(findGroupNum(arr));
    }
}