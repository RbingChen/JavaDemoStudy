package com.nextwork.sort;

public class BubbleSort {

    public static void bubbleSort(int nums[]){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length-i;j++){
                if(nums[j]<nums[j-1]) swap(nums,j-1,j);
            }
        }
    }
    public static void swap(int nums[],int i,int j){
        int tmp =nums[i];
        nums[i]=nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        int nums[] = new int[]{9,1,3,49,54,32};
        bubbleSort(nums);
        for(int i : nums){
            System.out.print(i+" ");
        }

    }
}
