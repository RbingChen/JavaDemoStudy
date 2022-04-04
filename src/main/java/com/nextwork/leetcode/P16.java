package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2022-04-02 20:04
 *  双指针
 * */
public class P16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length;i++){
            int left = i+1;
            int right = nums.length - 1;
            int more = target - nums[i];
            while(left < right && left < nums.length){
                int sum = nums[left] + nums[right];
                int tmp = more -sum;
                if( Math.abs(tmp)< Math.abs(close)){
                    close = tmp;
                }
                if(tmp>0)  left ++;
                else right --;
            }
        }
        return target - close;
    }
    public static void main(String args[]){

    }
}
