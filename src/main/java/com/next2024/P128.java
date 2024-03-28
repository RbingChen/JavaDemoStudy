package com.next2024;

import java.util.HashSet;
import java.util.Set;

public class P128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxNum = 0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int curNum = num;
                int curMax = 1;
                while(set.contains(curNum+1)){
                    curNum++;
                    curMax++;
                }
                maxNum = Math.max(maxNum,curMax);
            }
        }

        return maxNum;
    }
    public static void main(String args[]){

    }
}
