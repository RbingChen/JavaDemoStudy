package code2022;
import java.util.*;
public class P5 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int num : nums) {
            // 当队列的大小等于size时，计算最大值
            if (queue.size() == k) {
                int max = Integer.MIN_VALUE;
                for (int i : queue)
                    if (i > max) max = i;
                res.add(max);
                queue.poll();
            }
            queue.offer(num);
        }
        int max = Integer.MIN_VALUE;
        for (int i : queue)
            if (i > max) max = i;
        res.add(max);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
