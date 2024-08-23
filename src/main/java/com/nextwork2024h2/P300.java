package com.nextwork2024h2;
/*
*
示例 1：

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：

输入：nums = [0,1,0,3,2,3]
输出：4
* */
public class P300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len<=0) return len;
        int dp[] = new int[nums.length+1];
        dp[0] = 0;
        for(int i=1;i<=len;i++){dp[i]=1;}

        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i+1] = Math.max(dp[i+1],dp[j+1]+1);
                }
            }
        }
        return dp[len];
    }
    public static void main(String args[]){
        int nums[] = {10,9,2,5,3,7,101,18};
        P300 p300 = new P300();
        System.out.println(p300.lengthOfLIS(nums));
    }

}
