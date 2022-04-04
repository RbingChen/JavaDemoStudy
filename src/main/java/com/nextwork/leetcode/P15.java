package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.nextwork.leetcode.Print.printIntListListNode;

public class P15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lt = new ArrayList<>();

        for(int i = 0; i< nums.length;i++){
            while(i>0 &&i<nums.length&& nums[i]==nums[i-1] ) i++;
            if(i>=nums.length) return lt;
            int left = i+1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            while(left < right && left < nums.length){
                int sum = nums[left] + nums[right];
                if(target < sum ){
                    right--;
                    while(left < right && nums[right]==nums[right+1]) right--;
                }else if(target == sum ){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lt.add(list);
                    left++;
                    while(left < right && nums[left]==nums[left-1]) left++;
                }else{
                    left++;
                    while(left < right && nums[left]==nums[left-1]) left++;
                }
            }
        }
        return lt;
    }
    public static void main(String args[]){
        int nums[] = {-1,0,1,2,-1,-4};
        int nums2[] = {0,0};
        int nums3[] = {-2,0,0,2,2};
        printIntListListNode(threeSum(nums3));
    }
}
