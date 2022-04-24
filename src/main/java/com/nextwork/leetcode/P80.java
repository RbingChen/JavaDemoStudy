package com.nextwork.leetcode;

import java.util.List;

public class P80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;

        int ind = 1;
        int forward = 2;
        while(forward<nums.length){
            if(nums[forward]==nums[ind]){
                if(nums[ind-1]!=nums[ind]){
                    ind++;
                    swap(nums,forward,ind);
                }
            }else{
                ind++;
                swap(nums,forward,ind);
            }
            forward++;
        }
        return ind+1;
    }
    public void swap(int nums[],int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        P80 p80 = new P80();
        int nums[] = new int[]{1,1,1,2,2,3};
        System.out.println(p80.removeDuplicates(nums));
    }
}
