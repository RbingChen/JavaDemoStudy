package com.nextwork.sort;

import com.nextwork.leetcode.ListNode;

public class MergeSort {
    public static void sort(int []nums){
        sort(nums,0,nums.length-1);
    }
    public static void sort(int [] nums,int left,int right){
        int mid = (left+right)/2;
        if(left<right) {
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }
    public static void merge(int[] nums,int left,int mid,int right){
        int [] tmp = new int[right-left+1];
        int i = left,j=mid+1;
        int c = 0;
        while(i<=mid && j<=right){
            if(nums[i]<nums[j]){
                tmp[c++] = nums[i++];
            }else{
                tmp[c++] = nums[j++];
            }
        }
        while(i<=mid) tmp[c++] = nums[i++];
        while(j<=right) tmp[c++] = nums[j++];

        for(int k=0;k<tmp.length;k++){
            nums[k+left] = tmp[k];
        }
    }
    public void sort(ListNode head){
        sort(head,null);
    }
    public void sort(ListNode begin,ListNode end){
        ListNode mid = findMid(begin,end);
        if(begin!=mid){
            sort(begin,mid);
            sort(mid.next,end);
            merge(begin,mid,end);
        }
    }
    public void merge(ListNode head,ListNode mid,ListNode end){
        ListNode dummy = new ListNode(-1);

        while(head!=mid && mid!=end){

        }

    }
    public ListNode findMid(ListNode head,ListNode end){
         ListNode slow = head,fast=head;
         while(fast!=null && fast!=end && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
         }
         return slow;
    }
    public static void main(String args[]){
        int nums[] = new int[]{9,1,3,49,54,32};
        sort(nums);
        for(int i : nums){
            System.out.print(i+" ");
        }

    }
}
