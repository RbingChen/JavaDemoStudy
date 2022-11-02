package code2022;
import java.util.*;
public class P4 {
    public static int minMalwareSpread(int[][] graph, int[] initial) {

        int N = graph.length;
        // 1、使用color记录节点是否浏览过，并且进行联通图分组
        int[] colors = new int[N];
        Arrays.fill(colors, -1);
        int C = 0;

        for (int node = 0; node < N; ++node)
            if (colors[node] == -1)
                dfs(graph, colors, node, C++);
       // 2、记录每个分组的节点数量
        int[] size = new int[C];
        for (int color: colors)
            size[color]++;
       // 3、记录每个节点的 病毒节点数量
        int[] colorCount = new int[C];
        for (int node: initial)
            colorCount[colors[node]]++;
       // 4、 考虑病毒节点所在联通节点分组，只有1个病毒节点的情况。
       //     遍历所有这样的节点，并更新ans节点，获得最大的联通图。
        int ans = Integer.MAX_VALUE;
        for (int node: initial) {
            int c = colors[node];
            if (colorCount[c] == 1) {
                if (ans == Integer.MAX_VALUE)
                    ans = node;
                else if (size[c] > size[colors[ans]])
                    ans = node;
                else if (size[c] == size[colors[ans]] && node < ans)
                    ans = node;
            }
        }
       // 5、如果 4 不成立，这取最小节点。
        if (ans == Integer.MAX_VALUE)
            for (int node: initial)
                ans = Math.min(ans, node);

        return ans;
    }

    public static void dfs(int[][] graph, int[] colors, int node, int color) {
        colors[node] = color;
        for (int nei = 0; nei < graph.length; ++nei)
            if (graph[node][nei] == 1 && colors[nei] == -1)
                dfs(graph, colors, nei, color);
    }
    public static void main(String args[]){
        int graph[][]= {{1,1,0},{1,1,0},{0,0,1}};
        int inital[] ={0,1};
        System.out.println(minMalwareSpread(graph,inital));
    }
}
