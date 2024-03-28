package com.next2024;

public class P283 {

    public void moveZeroes(int[] nums) {

        int left=-1,right=0;

        while(left<=right && right<nums.length){

            if(nums[right]!=0){
                left++;
                if(left<right) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                }
            }
            right++;
        }
    }
    public static void main(String args[]){
        P283 p283 = new P283();
        int nums [ ]= new int[]{0,1,0,3,12};
        p283.moveZeroes(nums);
        for(int num:nums){
            System.out.print(num+" ");
        }
    }
}
