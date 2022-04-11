package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
          Arrays.sort(candidates);
          if(candidates.length==0 || target < candidates[0]) return result;
          backTrack(candidates,target,new ArrayList<Integer>(),0);
          return result;
    }
    public void backTrack(int[] candidates,int left,List<Integer> list,int begin){
        if(left==0){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            result.add(tmp);
            return ;
        }else{
            if(left < candidates[0]){
                return;
            }
            for(int i = begin;i< candidates.length;i++){
                list.add(candidates[i]);
                backTrack(candidates,left - candidates[i],list,i);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String args[]){
       P39 p38 = new P39();
       int nums[] = new int[]{2,3,5};
       List<List<Integer>> lt = p38.combinationSum(nums,8);
       p38.Print(lt);

    }
    void Print( List<List<Integer>> lt){
        for(List<Integer> t : lt){
            for(int i : t){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
