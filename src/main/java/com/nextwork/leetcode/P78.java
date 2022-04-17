package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P78 {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0,new ArrayList<>());
        return result;
    }
    public void backTrack(int nums[],int begin,List<Integer> list){
            for(int i=begin;i<nums.length;i++) {
                list.add(nums[i]);
                backTrack(nums, i + 1, list);
                list.remove(list.size()-1);
            }
        List lt = new ArrayList();
        lt.addAll(list);
        result.add(lt);

    }
    public static void main(String args[]){
        P78 p78 = new P78();
        int nums[] = new int[]{1,2,3};
        List<List<Integer>> res = p78.subsets(nums);
        Print.printIntListListNode(res);
    }
}
