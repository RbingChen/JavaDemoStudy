package com.nextwork2024h2;
import java.util.*;
public class P15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return null ;
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            int target = 0 - nums[i];
            int left = i+1,right = nums.length-1;
            while(left<right){
                int tmp = nums[left] + nums[right];
                if(tmp>target){
                    right--;
                }else if(tmp==target){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);res.add(nums[left]);res.add(nums[right]);
                    ret.add(res);
                    while(right>left && nums[left++]==nums[left]){}
                }else{
                    left++;
                }
            }
        }
        return ret;
    }
    public static void main(String args[]){

    }
}
