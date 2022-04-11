package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P46 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0) return result;
        if(nums.length==1) {}
        boolean flag[] = new boolean[nums.length];
        backTrack(nums,new ArrayList<Integer>(),flag,nums.length);
        return result;
    }

    public void backTrack(int[] nums,List<Integer> list,boolean flag[],int left){
        if(left==0){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            result.add(tmp);
            return ;
        }else{
            for(int i = 0;i< nums.length ;i++){
                if(flag[i]) continue;
                flag[i]=true;
                list.add(nums[i]);
                backTrack(nums,list,flag,left-1);
                list.remove(list.size()-1);
                flag[i]=false;
            }
        }

    }
    public static void main(String args[]){
        P46 p46 = new P46();
        int nums[] = new int[]{1,2,3};
        List<List<Integer>> lt = p46.permute(nums);
        p46.Print(lt);

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
