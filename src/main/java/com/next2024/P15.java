package com.next2024;

import org.apache.spark.sql.sources.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class P15 {

    public List<List<Integer>> threeSum_error(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        support(ret,res,nums,0,3,0);
        return ret;
    }
    // 用不了回溯法
    public void support(List<List<Integer>> ret, List<Integer> res,int[] nums, int begin, int cnt, int sum){
        if(cnt==0){
            if(sum==0) ret.add(new ArrayList<>(res));
            return;
        }else{
            for(int i=begin;i<nums.length;i++){
                //if(i>0 && nums[i]!=nums[i-1]) {
                    res.add(nums[i]);
                    utils.printList(res);
                    support(ret, res, nums, i + 1, cnt - 1, sum + nums[i]);
                    System.out.println("index : "+ i + " size : " + res.size());
                    res.remove(res.size() - 1);
                    utils.printList(res);
                    support(ret, res, nums, i + 1, cnt, sum);
               // }
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return null;
        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);
        int left=0,right=0;
        for(int i = 0;i<nums.length;i++){
            //int sum = nums[i];
            if(i>0 && nums[i]==nums[i-1]) continue;
            left = i+1;
            right = nums.length-1;
            while(right>left){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);res.add(nums[left]);res.add(nums[right]);
                    ret.add(res);
                    utils.printList(res);

                    while(right>left && nums[left++] == nums[left]){}
                }
                else if(sum>0){
                    while(right>left && nums[right--] == nums[right]){
                    }
                }else{
                    while(right>left && nums[left++] == nums[left]){}
                }

            }
        }
        return ret;
    }
    public static void main(String args[]){
        int nums[] = {-1,0,1,2,-1,-4};
        P15 p15 = new P15();
        p15.threeSum(nums);
    }
}
