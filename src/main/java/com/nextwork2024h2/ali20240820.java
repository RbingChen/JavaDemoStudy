package com.nextwork2024h2;

import java.util.*;

public class ali20240820 {

    public  List<List<Integer>> checkDoubleArray(int B[]){
        List<List<Integer>> ret = new ArrayList();
        boolean flag [] = new boolean[B.length];
        support(ret,B,new ArrayList<Integer>(),flag);
        return ret;

    }

    public void support(List<List<Integer>> ret,int B[], List<Integer> lt ,boolean flag[]){
        if(lt.size()==B.length/2) {
            ret.add(new ArrayList(lt));
            return ;
        }

        for(int i=0;i<B.length;i++){
            if(flag[i]) continue;
            int findIndex = find(B[i]*2,B);

            if(findIndex>=0 && flag[i]==false &&flag[findIndex]==false){
                lt.add(B[i]);
                flag[i] = true;
                flag[findIndex] = true;
                support(ret,B,lt,flag);
                lt.remove(lt.size()-1);
                flag[i] = false;
                flag[findIndex] = false;
            }
        }
    }
    public int find(int target,int B[]){
        for(int i=0;i<B.length;i++){
            if(B[i]==target) return i ;
        }
        return -1;
    }
    public static void main(String args[]){
        int B [] ={1,6,4,2,3,8,5,11};
        ali20240820  test = new ali20240820();
        List<List<Integer>> ret = test.checkDoubleArray(B);
        for(List<Integer> lt :ret){
            for(int i : lt){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
