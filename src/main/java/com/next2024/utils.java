package com.next2024;

import java.util.*;

public class utils {
    public static void  printList(List<Integer> list){

        for(int i : list){
            System.out.print(i+" ");
        }
        System.out.println();

    }
    public static void sortArray(int intervals[][]) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
    }
}
