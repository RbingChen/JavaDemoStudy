package com.nextwork.leetcode;

public class P560 {
    boolean visited[];
    int count = 0;
    public int subarraySum(int[] nums, int k) {
        visited = new boolean[nums.length];
        backTrack(nums,0,k,0);
        return count;
    }
    public void backTrack(int []nums,int i,int k,int c){
        if(k==0 && c>0){
            count++;
        }
                if(i<nums.length) {
                    if (c >= 1 && !visited[i - 1]) return;
                    visited[i] = true;
                    backTrack(nums, i + 1, k - nums[i], c + 1);
                    visited[i] = false;
                    backTrack(nums, i + 1, k, c);
                }

    }
    public static void main(String args[]){
        P560 p560 = new P560();
        int nums[] = new int[]{1,-1,0};
        System.out.println(p560.subarraySum(nums,0));
    }
}
