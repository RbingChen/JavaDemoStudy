package com.nextwork2024h2;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

/*
* 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]*/
public class P189 {
    public void rotate(int[] nums, int k) {
       k = k%nums.length;
       reverse(nums,0,nums.length-1);
       reverse(nums,0,k-1);
       reverse(nums,k,nums.length-1);
    }
    public void reverse(int [] nums,int i ,int j){
        while(i<j){
            int a = nums[i];
            nums[i] = nums[j];
            nums[j] = a;
            i++;j--;
        }

    }
    public void rotateXX(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int cnt = 0;
        int ind = 0 ;
        int hold = nums[0];
        while(cnt<len){
            int mvInd = (ind+k)%len;
            int tmp  = nums[mvInd];
            nums[mvInd] = hold;
            hold = tmp ;
            ind = mvInd;
            cnt++;
        }
    }
    public static void main(String args[]){
        int nums[] ={1,2,3,4,5,6,7};
        P189 p189 = new P189();
        p189.rotate(nums,3);
        for(int i : nums){
            System.out.println(i);
        }
    }
}
