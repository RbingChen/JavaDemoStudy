package com.nextwork.leetcode;
/*
 *  2022 - 04 - 09 23:32
 *  注意长度相同
 * */
public class P33 {
    public static int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        if(nums.length==1 && nums[0]==target) return 0;
        int left = 0,right = nums.length-1;
        // 等号搞得难受
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] ==target) return mid;
            if(nums[0] <= nums[mid]){
               if(nums[0]<=target && target < nums[mid]){
                   right = mid-1;
               }else{
                   left = mid+1;
               }
            }else{
                if(nums[mid]<target && target <=nums[nums.length-1]){
                    left  = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){

      int nums[] = new int[]{4,5,6,7,0,1,2};
        int nums2[] = new int[]{4,5,6,7,8,1,2,3};
      System.out.println(search(nums2,8));
    }
}
