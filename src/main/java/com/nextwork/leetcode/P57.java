package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P57 {
    class Pair implements Comparable<Pair>{
        int k;
        int v;
        Pair(int k,int v){
            this.k = k;
            this.v = v;
        }
        public int compareTo(Pair p){
            return Integer.compare(this.k,p.k);
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Pair> lp = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            lp.add(new Pair(intervals[i][0],intervals[i][1]));
        }
        lp.add(new Pair(newInterval[0],newInterval[1]));
        Collections.sort(lp);
        return merge(lp);
    }
    public int[][] merge(List<Pair> lp) {

        List<Pair> result = new ArrayList<>();
        for(int i =0;i<lp.size();i++){
            if(result.isEmpty()){
                result.add(lp.get(i));
            }else{
                Pair p1 = result.get(result.size()-1);
                Pair p2 = lp.get(i);
                if(p1.v >=p2.k){
                    if(p2.v>p1.v) p1.v= p2.v;
                }else{
                    result.add(p2);
                }
            }
        }
        int[][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            Pair p1 = result.get(i);
            res[i][0] = p1.k;
            res[i][1] = p1.v;
        }
        return res;
    }
    public static void main(String args[]){
        P57 p57 = new P57();
        int nums[][] = new int[][]{{1,3},{6,9}};
        int nums2[][] = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        p57.print(p57.insert(nums,new int[]{2,5}));
       // p56.print(p56.merge(nums2));
    }
    void print(int [][] nums){
        for(int i =0;i<nums.length;i++){
            System.out.println(nums[i][0]+" "+nums[i][1]);
        }
    }

}
