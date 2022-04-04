package com.nextwork.leetcode;

public class P1 {
    public static int[] twoSum(int[] nums, int target) {
         if(nums.length<2) return null;
         int i =0,j=0;
         for(i=0;i<nums.length-1;i++){
             int tmp = target - nums[i];
             for(j=i+1;j<nums.length;j++){
                 if(nums[j]==tmp){
                     return new int[]{i,j};
                 }
             }
        }
         return null;
    }
    public static int[] twoSumV2(int nums[],int target){
        return null;
    }
    public static void main(String args[]){
        int nums[] = new int[]{2,7,11,15};
        int target = 9;
        int result[] = twoSum(nums,target);
        Print.printIntArray(result);
    }
}
