package com.nextwork2024h2;

public class P238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length<=1) return nums;
        int left[] = new int[nums.length];
        left[0]=1;
        int right[] = new int[nums.length];
        right[nums.length-1] = 1;

        for(int i =1;i<nums.length;i++){
            left[i] = nums[i-1]*left[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
           right[i] = nums[i+1]*right[i+1];
        }
        for(int i = 0;i<nums.length;i++){
            left[i] = left[i] * right[i];
        }
        return left;
    }
    public static void main(String args[]){
        int nums[] ={-1,1,0,-3,3};
        P238 p238 = new P238();
        nums = p238.productExceptSelf(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }
}
