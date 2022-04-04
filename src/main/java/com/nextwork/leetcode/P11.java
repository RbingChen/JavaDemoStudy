package com.nextwork.leetcode;
/**
 * 2022-04-02 19:04
 *  双指针
 * */
public class P11 {
    public static int maxArea(int[] height) {
        int res = 0;
        int left = 0 , right = height.length-1;
        while(left < right){
            res = Math.max(res,(right-left)*Math.min(height[left],height[right]));
            if(height[left] < height[right]){
                left ++;
            }else right--;
        }
        return res;
    }
    public static void main(String args[]){
        int nums[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

}
