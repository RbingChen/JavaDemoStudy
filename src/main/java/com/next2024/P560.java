package com.next2024;

public class P560 {

    public int subarraySum(int[] nums, int k) {
        int cnt = 0 ;
        for(int i = 0;i<nums.length;i++){
            int sum = nums[i];
            if(sum==k) cnt++;
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) cnt++;
            }
        }
        return cnt;
    }
    public int subarraySum2(int[] nums, int k) {
        return 0;

    }

    public static void main(String args[]){
        int nums[] = {1,1,1};
        P560 p560 = new P560();

        System.out.println(p560.subarraySum(nums,2));

    }
}
