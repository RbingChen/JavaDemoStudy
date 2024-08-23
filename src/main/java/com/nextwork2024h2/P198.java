package com.nextwork2024h2;
/*
* 输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

* */
public class P198 {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int dp[][] = new int[nums.length+1][2];

        for(int i=0;i<nums.length;i++){
            dp[i+1][0] = Math.max(dp[i][1],dp[i][0]);
            dp[i+1][1] = dp[i][0]+nums[i];
        }
        return Math.max(dp[nums.length][0],dp[nums.length][1]);
    }
    public static void main(String args[]){
        int nums[] = {2,7,9,3,1};
        P198 p198 = new P198();
        System.out.println(p198.rob(nums));
    }

}
