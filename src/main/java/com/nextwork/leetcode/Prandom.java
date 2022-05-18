package com.nextwork.leetcode;

import java.util.Random;

public class Prandom {

    public static void main(String args[]){
        int nums[] = new int[5];
        Random random = new Random();
        for(int i=0;i<10000;i++){
            int val =0;
            for(int j=0;j<5;j++) val +=random.nextInt(4);
            nums[val%5]++;
        }
        for(int k : nums){
            System.out.print(k+" ");
        }
    }
}
