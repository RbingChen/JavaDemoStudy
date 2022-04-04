package com.nextwork.leetcode;
/**
 * 2022-03-31 21:36
 * 步长法
 * */
public class P4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums1.length;
        if(len1==0 && len2==0) return 0.0;
        if(len1 == len2)
            return getK(nums1,0,nums2,0,(len1+len2)/2);
        return 0.0;
    }
    public double getK(int[] nums1,int s1,int []nums2,int s2,int k){
        if(s1>nums1.length-1) return nums2[s2+k-1];
        if(s2>nums2.length-1) return nums1[s1+k-1];
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if(k==1) return Math.min(nums2[s2],nums1[s1]);
        if(s1+k/2-1 < nums1.length) mid1 = nums1[s1+k/2-1];
        if(s2+k/2-1 < nums2.length) mid2 = nums2[s2+k/2-1];
        if(mid1<mid2) return getK(nums1,s1+k/2,nums2,s2,k-k/2);
        else return getK(nums1,s1,nums2,s2+k/2,k-k/2);
    }
    public static void main(String args[]){

    }
}
