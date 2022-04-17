package com.nextwork.leetcode;
/***
 *  2022 - 04 -13 18：:28
 *  注意  0  和  2 交换
 */
public class P75 {
    public void sortColors(int[] nums) {
       int left = 0,right = nums.length-1;

       for(int i =0;i<nums.length ;i++){

           while(i<right && nums[i]==2){
               swap(nums,i,right);
               right--;
           }
           if(nums[i]==0){
               swap(nums,i,left);
               left++;
           }
       }
    }
    public void sortColorsV2(int[] nums) {
        int left = 0,right = nums.length-1;
        int i = 0;
        while(i <=right){
            if(nums[i]==2){
                swap(nums,right,i);
                right--;
            }
            else if(nums[i]==0){
                swap(nums,left,i);
                left++;
            }else{
                i++;
            }
        }
    }

    public void swap(int nums[],int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        //int nums[] = new int[]{2,0,2,1,1,0};
        int nums2[] = new int[]{1,2,0};
        P75 p75 = new P75();
        p75.sortColorsV2(nums2);
        for(int i :nums2){
            System.out.print(i+" ");
        }
    }
}
