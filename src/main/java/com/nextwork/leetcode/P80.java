package com.nextwork.leetcode;

import java.util.List;

public class P80 {
    public int removeDuplicates(int[] nums) {
      if(nums.length<=2) return nums.length;
      int begin=1,i = 1;
      int count=1;
      while(i==0){
          if(nums[i]==nums[-1]){
              count++;
              if(count==3){
                  swap(nums,i);
              }
          }
          i++;
      }
      return 0;
    }
    public void swap(int nums[],int i){
        for(int j=i+1;j<nums.length && i<nums.length;j++){
            int tmp = nums[j];
            nums[j]=nums[i];
            nums[i]=tmp;
            i=j;
        }
    }
    public static void main(String args[]){
        P80 p80 = new P80();
        int nums[] = new int[]{1,1,1,2,2,3};
        System.out.println(p80.removeDuplicates(nums));
    }
}
