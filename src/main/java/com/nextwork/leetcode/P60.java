package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P60 {
    public String getPermutation(int n, int k) {
        List<String> lt = new ArrayList();
        boolean visited[] = new boolean[n];
        backTrack(lt,visited,"",0);
        Collections.sort(lt);
        return lt.get(k-1);
    }

    public void backTrack(List<String> lt , boolean[] set, String str, int count){
        if(str.length()==set.length){
            lt.add(str);
            return;
        }else{
            //System.out.println(str);
            for(int i=0;i<set.length;i++){
                if(!set[i]){
                    set[i] = true;
                    backTrack(lt,set,str+(i+1),count++);
                    set[i] = false;
                }

            }

        }
    }

    public static void main(String args[]){
        P60 p60 = new P60();
        System.out.println(p60.getPermutation(3,2));
    }

}
