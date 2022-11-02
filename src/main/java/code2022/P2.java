package code2022;
import java.util.*;
public class P2 {
    public int maxArea(int[] g, int[] s,int h, int w) {
        long horizonMax = 0, verticalMax = 0;
        int mod = 1000000007;
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 1; i < g.length; i++) {
            horizonMax = Math.max(horizonMax, g[i] - g[i - 1]);
        }
        // 补充验证边界切割位置
        horizonMax = Math.max(horizonMax, g[0] - 0);
        horizonMax = Math.max(horizonMax, h - g[g.length - 1]);

        for (int i = 1; i < s.length; i++) {
            verticalMax = Math.max(verticalMax, s[i] - s[i - 1]);
        }
        // 补充验证边界切割位置
        verticalMax = Math.max(verticalMax, s[0] - 0);
        verticalMax = Math.max(verticalMax, w - s[s.length - 1]);

        return (int) ((horizonMax * verticalMax) % mod);
    }

    public static void main(String args[]) {
        int h = 5;
        int w= 4;
        int hCuts[] = {1,2,4};
        int wCuts[] = {1,3};
    }
}
