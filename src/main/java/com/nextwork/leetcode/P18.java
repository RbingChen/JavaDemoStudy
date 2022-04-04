package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.nextwork.leetcode.Print.printIntListListNode;

/*
*  2022 - 04 - 04 23:25
* */
public class P18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i< len-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<len-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int tt = target - nums[i] -nums[j];

                int left = j+1;
                int right = len-1;

                while(left < right && left < len){
                    int sum = nums[left] + nums[right];
                    if(tt>sum){
                        left++;
                        while(left<right && nums[left]==nums[left-1]) left++;
                    }else if(tt==sum){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        right--;
                        while(left<right && nums[right]==nums[right+1]) right--;
                    }else{
                        right--;
                        while(left<right && nums[right]==nums[right+1]) right--;
                    }
                }

            }

        }
        //System.out.println(result.size());
        return result;
    }

    public static void main(String args[]){
        int num[] = {2,2,2,2,2};
        printIntListListNode(fourSum(num,8));
        int num1[] = {1,0,-1,0,-2,2};
        printIntListListNode(fourSum(num1,0));
    }

}
