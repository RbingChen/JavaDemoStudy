package com.nextwork.sort;

public class QuickSort {
    public static void quickSort(int []data){

            quickSort(data,0,data.length-1);

    }
    public static void quickSort(int []data, int start,int end){
        if(start<end){
            int mid = partition(data,start,end);
            quickSort(data,start,mid-1);
            quickSort(data,mid+1,end);
        }
    }
    public static int partition(int[] data,int start,int end){
        if(start>=end) return start;
        int key = data[end];
        int p = start-1;
        for(int i=start;i<end;i++){
            if(data[i]<key){
                swap(data,i,p+1);
                p++;
            }
        }
       swap(data,end,p+1);
        return p+1;
    }
    public static void swap(int[] data,int i,int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static int findKthLargest(int nums[],int k){
        int mid = 0;
        int left = 0,right = nums.length-1;
        while(left<right) {
            mid = partition(nums, left, right);
            if (mid == k - 1) return nums[mid];
            else if (mid < k - 1) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return nums[k-1];
    }
    public static void main(String args[]){
        int nums[] = new int[]{9,1,3,49,54,32};
        quickSort(nums);
        for(int i : nums){
            System.out.print(i+" ");
        }
       System.out.println();
        System.out.println(findKthLargest(nums,4));
    }
}
