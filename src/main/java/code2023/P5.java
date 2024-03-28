package code2023;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;


class Pair<K, V> {
    public K first;
    public V second;
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}
public class P5 {
    public static int mostBooked(int n, int[][] meetings) {
        // 按开始时间排序
        Arrays.sort(meetings, (x, y) -> x[0] - y[0]);
        int[] count = new int[n];
        // TreeSet 记录此时所有可用的会议室（也可以用 PriorityQueue）
        TreeSet<Integer> meetingRoom = new TreeSet<>();
        for (int i = 0; i < n; i++)
            meetingRoom.add(i);
        // 优先队列记录 {结束时间，占用的会议室}，优先按照结束时间排序
        PriorityQueue<Pair<Long, Integer>> heap = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first) == 0 ? x.second - y.second : Long.compare(x.first, y.first));
        // 顺序遍历会议室，先遍历到的肯定是开始时间早的
        for (int[] meeting : meetings) {
            // 如果有结束时间早于当前会议开始时间的会议，都先弹出优先队列（不会对后面的会议造成影响）
            while (!heap.isEmpty() && meeting[0] >= heap.peek().first)
                meetingRoom.add(heap.poll().second);
            // 如果 TreeSet 中获取不到空的会议室，就弹出最早结束的会议把会议室腾出来，但是结束时间要设置为"弹出会议的结束时间 + 当前会议的持续时间"，因为要等待会议结束
            if (meetingRoom.isEmpty()) {
                Pair<Long, Integer> cur = heap.poll();
                count[cur.second]++;
                heap.offer(new Pair<>(cur.first + (long) meeting[1] - meeting[0], cur.second));
            }
            // 有空会议室直接分配即可
            else {
                int get = meetingRoom.first();
                heap.offer(new Pair<>((long) meeting[1], get));
                count[get]++;
                meetingRoom.remove(get);
            }
        }
        // 最后计算最大的会议室下标
        int max = 0;
        for (int i = 1; i < n; i++)
            if (count[max] < count[i])
                max = i;
        return max;
    }

}
