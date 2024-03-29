package com.nextwork.leetcode;

public class P31 {
    public void nextPermutation(int[] nums) {
       int i = nums.length - 2;
       while(i>=0 && nums[i]>=nums[i+1]){
           i--;
       }
       if(i >=0){
           int j = nums.length -1;
           while(j >=0 && nums[i]>=nums[j]){
               j--;
           }
           swap(nums,i,j);
       }
       reverse(nums,i+1);
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[] nums,int k){
        int left = k,right = nums.length-1;
        while(left < right){
            swap(nums,left,right);
            left ++;
            right --;
        }
    }
    public static void main(String args[]){

    }
}
