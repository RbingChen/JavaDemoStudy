package com.nextwork.leetcode;

public class P81 {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        if(nums.length==1) return nums[0]==target;
        int left = 0,right = nums.length-1;

        while(left<=right){

            int mid = (left+right)/2;
            if(nums[mid]==target) return true;
            if(nums[left]==nums[mid]){
                left++;continue;
            }
            if(nums[left]<nums[mid]){
               if(nums[mid]>target && nums[left]<=target){
                   right = mid-1;
               }else{
                   left = mid+1;
               }
            }else{
                if(nums[mid]<target && nums[right]>=target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return  false;
    }
    public static void main(String args[]){

    }
}
