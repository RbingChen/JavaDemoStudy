package com.nextwork2024h2;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.apache.spark.sql.sources.In;

import java.util.HashMap;
import java.util.Map;
/*
* 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。


示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
* */
public class P128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map  = new HashMap();
        int maxLen = 0 ;
        for(int i =0;i<nums.length;i++){
            int tmp = nums[i];
            if(map.containsKey(tmp-1)){
               map.put(tmp,map.get(tmp-1)+1);
               maxLen = Math.max(maxLen,map.get(tmp));
            }else{
                map.put(tmp,1);
            }
            tmp++;
            int pre = nums[i];
            while(map.containsKey(tmp)){
                map.put(tmp,map.get(pre)+1);
                maxLen = Math.max(maxLen,map.get(tmp));
                pre = tmp;
                tmp++;

            }
        }
     return maxLen;
    }
    public static void main(String args[]){
        int nums[] ={0,3,7,2,1,5,8,4,6,0};
        P128 p128 = new P128();
        System.out.println(p128.longestConsecutive(nums));

    }
}
