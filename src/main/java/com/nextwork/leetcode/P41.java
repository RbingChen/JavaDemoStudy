package com.nextwork.leetcode;

import java.util.List;

public class P41 {
    public int firstMissingPositive(int[] nums) {
       for(int i = 0;i<nums.length;i++){

            while(nums[i]<=nums.length && nums[i]> 0 && nums[nums[i]-1]!=nums[i]) {
                swap(nums,i,nums[i]-1);
            }
       }
       for(int i=0;i<nums.length;i++){
           if(nums[i]!=i+1)
               return i+1;
       }
       return nums.length+1;
    }
    public void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String args[]){
        P41 p41 = new P41();
        int nums1[] = new int[]{1,2,0};
        int nums2[] = new int[]{7,8,9,11,12};
        int nums3[] = new int[]{3,4,-1,1};
       System.out.println(p41.firstMissingPositive(nums1));
        System.out.println(p41.firstMissingPositive(nums2));
        System.out.println(p41.firstMissingPositive(nums3));

    }
}
