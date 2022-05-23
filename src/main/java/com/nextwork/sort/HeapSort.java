package com.nextwork.sort;

public class HeapSort {
    public static void heapSort(int[] nums){
        buildHeap(nums);
        int size = nums.length;
        for(int i=nums.length-1;i>=0;i--){
            swap(nums,0,i);
            size--;
            maxHeapify(nums,0,size);
        }
    }
    public static void buildHeap(int[] nums){
        int size = nums.length;
        for(int i=size/2;i>=0;i--){
            maxHeapify(nums,i);
        }
    }
    public static void maxHeapify(int[] nums,int i,int size){
        int left = getLeftIndex(i);
        int right = getRightIndex(i);
        int largest = i;
        if(left<size && nums[left]> nums[largest]) largest = left;
        if(right<size && nums[right]> nums[largest]) largest = right;
        if(largest!=i){
            swap(nums,i,largest);
            maxHeapify(nums,largest,size);
        }
    }
    public static void maxHeapify(int[] nums,int i){
             maxHeapify(nums,i,nums.length);
    }
    private static  int getLeftIndex(int i){
        //索引 从0 开始
        return 2*i+1;
    }
    private static  int getRightIndex(int i){
        return 2*i+2;
    }
    public static void swap(int[] data,int i,int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    public static void main(String args[]){
        int nums[] = new int[]{9,1,3,49,54,32};
        heapSort(nums);
        for(int i : nums){
            System.out.print(i+" ");
        }

    }
}
