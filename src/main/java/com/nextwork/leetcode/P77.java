package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P77 {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
       backTrack(n,1,k,new ArrayList<>());
       return result;
    }
    public void backTrack(int n,int begin,int left,List<Integer> list){
        if(left==0){
            List lt = new ArrayList();
            lt.addAll(list);
            result.add(lt);
        }else{
            for(int i=begin;i<=n;i++) {
                list.add(i);
                backTrack(n, i + 1, left-1, list);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String args[]){
        P77 p77 = new P77();
        List<List<Integer>> res = p77.combine(4,2);
        Print.printIntListListNode(res);
    }
}
