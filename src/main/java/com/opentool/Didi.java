package com.opentool;

// a =[ 1,1,2,3] ==》 [1,2,3]
public class Didi {
    public int[] removeDupliateNum(int [] nums){
        if(nums.length<=1) return nums;
        int begin = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[begin]!=nums[i]){
                begin++;
                swap(nums,begin,i);
            }
        }
        System.out.println("len :"+begin);
        return nums;
    }
    public void swap(int nums[],int i,int j){
        int tmp = nums[i];
        nums[i]= nums[j] ;
        nums[j] = tmp;
    }
    public void print(int nums[]){
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
         Didi didi = new Didi();

         int nums1[] = new int[]{1,1,2};
         didi.print(didi.removeDupliateNum(nums1));

         int nums2[] = new int[]{1,1,2,2,3};
         didi.print(didi.removeDupliateNum(nums2));

    }

}
