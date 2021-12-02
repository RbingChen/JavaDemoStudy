package com.cimon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YcThird {

    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        int arrSize = reader.nextInt();
        int[] arr = new int[arrSize];
        int i=0;
        while(reader.hasNext()){
            arr[i++] = reader.nextInt();
            if(i == arr.length) break;
        }
        System.out.println(formatArr(minimumAbsDifference(arr)));
    }
    public static String formatArr(List<List<Integer>> list){
        StringBuilder st = new StringBuilder();
        st.append("[");
        for(List<Integer> lp1 : list){
            int ind=0;
            for(int num : lp1){
                if(ind==0) {
                    st.append("[");
                    st.append(String.valueOf(num));
                    st.append(",");
                }
                if(ind==1) {
                    st.append(String.valueOf(num));
                    st.append("],");
                }
                ind ++;
            }
        }
        st.deleteCharAt(st.length()-1);
        st.append("]");
        return st.toString();
    }
    public static List<List<Integer>> minimumAbsDifference(int arr[]){
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int min = Math.abs(arr[1] - arr[0]);;
        for(int i = 1;i < arr.length ;++i){
            min = Math.min(min,Math.abs(arr[i]-arr[i-1]));
        }

        for(int j = 0;j < arr.length - 1;++j){
            if(arr[j] + min == arr[j+1]){
                List<Integer> row = new ArrayList<Integer>();
                row.add(arr[j]);
                row.add(arr[j+1]);
                resList.add(row);
            }
        }

        return resList;

    }
}
