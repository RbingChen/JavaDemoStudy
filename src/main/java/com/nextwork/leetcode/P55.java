package com.nextwork.leetcode;

import java.util.List;

public class P55 {
    public boolean canJump(int[] nums) {

       if(nums.length<=1) return true;
       int end=0;

       for(int i=0;i<nums.length;i++){
           if(i>end) return false;
           if(i+nums[i]>end){
               end = i + nums[i];
           }
           if(end >=nums.length-1)
               return true;
       }
       return false;
    }
    public static void main(String args[]){
        P55 p55 = new P55();
        int nums[] = new int[]{2,3,1,1,4};

        System.out.println(p55.canJump(nums));
        int nums2[] = new int[]{3,2,1,0,4};
        System.out.println(p55.canJump(nums2));

    }
}
