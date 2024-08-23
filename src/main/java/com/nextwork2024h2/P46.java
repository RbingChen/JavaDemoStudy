package com.nextwork2024h2;
import java.util.*;

public class P46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean flag [] = new boolean[nums.length];
        search(ret,new ArrayList<Integer>(),nums,flag);
        return ret;
    }
    public void search(List<List<Integer>> ret,List<Integer> lt,int[] nums,boolean flag[]){
       if(lt.size()==nums.length){
           ret.add(new ArrayList<>(lt));
       }
        for(int i = 0;i<nums.length;i++){
            if(flag[i]==false){
                lt.add(nums[i]);
                flag[i] = true;
                search(ret,lt,nums,flag);
                flag[i] = false;
                lt.remove(lt.size()-1);
            }
        }
    }

}
