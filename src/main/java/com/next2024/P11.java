package com.next2024;

public class P11 {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){

            if(height[left]<height[right]){
                maxArea = Math.max((right-left)*height[left],maxArea);
                left++;
            }else{
                maxArea = Math.max((right-left)*height[right],maxArea);
                right++;
            }
        }
        return maxArea;
    }
}
