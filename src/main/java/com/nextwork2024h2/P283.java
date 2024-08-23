package com.nextwork2024h2;
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。
示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:
输入: nums = [0]
输出: [0]
* */
public class P283 {
    public void moveZeroes(int[] nums) {
        if (nums==null) return ;
        int zeroIndex = 0;

        for(int i=0;i<nums.length;){
            if(nums[i]!=0){
                nums[zeroIndex++] = nums[i];
            }
        }
        for(int i=zeroIndex;i<nums.length;i++){

                nums[zeroIndex] = 0;
        }
    }

}
