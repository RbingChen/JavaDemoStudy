package com.nextwork2024h2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
public class P56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> ret = new ArrayList();
        for(int i =0 ;i<intervals.length;i++){
            int right = intervals[i][1];
            int j = i+1;
            while(j<intervals.length && intervals[j][0]<=right){
                right = Math.max(intervals[j][0],right);
                j++;
            }
            int tmp[] = {intervals[i][0],right};
            i = j;
            ret.add(tmp);

        }
        return ret.toArray(new int[ret.size()][]);
    }
}
