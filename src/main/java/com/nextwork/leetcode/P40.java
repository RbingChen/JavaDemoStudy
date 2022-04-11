package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                // 每个数字，只作为一次开始？
                if(i>begin  && candidates[i]==candidates[i-1]) continue;
                list.add(candidates[i]);
                backTrack(candidates,left - candidates[i],list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String args[]){
       P40 p38 = new P40();
       int nums[] = new int[]{10,1,2,7,6,1,5};
       List<List<Integer>> lt = p38.combinationSum2(nums,8);
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
