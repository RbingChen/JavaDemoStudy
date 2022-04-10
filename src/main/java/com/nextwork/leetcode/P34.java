package com.nextwork.leetcode;
/*
 *  2022 - 04 - 09 23:32
 *  注意长度相同
 */
public class P34 {
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(nums.length==0) return new int[]{-1,-1};
        if(nums.length==1 && target==nums[0]) return new int[]{0,0};

        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid]==target){
                int l = mid-1;
                int r = mid+1;
                while(l>=0 && nums[l]==target) l--;
                while(r<len && nums[r] == target) r++;
                return new int[]{l+1,r-1};
            }else if(nums[mid]>target) right = mid-1;
            else left = mid+1;
        }
        return new int[]{-1,-1};
    }
    public static void main(String args[]){

        int nums[] = new int[]{5,7,7,8,8,10};

        int result[] = searchRange(nums,8);
        System.out.println(result[0]+" "+ result[1]);
    }
}
