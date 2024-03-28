package code2023;
/**
 * 小岛 https://zhuanlan.zhihu.com/p/189567861
 * */
public class P6 {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid == null || n == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ret += 4;
                    if (j > 0 && grid[i][j - 1] == 1) {
                        ret -= 2;
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        ret -= 2;
                    }


                }
            }
        }
        return ret;
    }
}
