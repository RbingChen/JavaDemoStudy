package com.nextwork.sword2offer;

import java.util.Deque;
import java.util.LinkedList;

public class SP59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[i]>deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        int ind=0;
        res[ind++] =deque.peekFirst();
        for(int i=1;i<nums.length-k;i++){
            if(deque.peekFirst()==nums[i-1]){
                deque.pollFirst();
            }
            while(i>=k &&!deque.isEmpty() && nums[i]>deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            res[ind++] =deque.peekFirst();

        }
        return res;

    }
    public static void main(String args[]){
        int nums[] = new int[]{1,3,-1,-3,5,3,6,7};
        SP59 sp59 = new SP59();
        int res[]= sp59.maxSlidingWindow(nums,3);
    }
}
