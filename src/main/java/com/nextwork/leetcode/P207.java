package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P207 {
    Map<Integer,List<Integer>> edge = new HashMap();
    int visited[];
    boolean flag = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return flag;
        visited = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int key = prerequisites[i][1];
            if(!edge.containsKey(key)){
                edge.put(key,new ArrayList());
            }
            edge.get(key).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++ ){
            if(visited[i]==0) dfs(i);
        }
        return flag;
    }

    public void dfs(int i){
        visited[i] =1 ;
        List<Integer> lt = edge.get(i);
        if(lt!=null){
            for(int j : lt){
                if(visited[j]==0){
                    dfs(j);
                    if(!flag) return;
                }else if(visited[j]==1){
                    flag=false;
                    return;
                }
            }
        }
        visited[i]=2;

    }
    public static void main(String args[]){
        int nums[][] = new int[][]{{1,0}};
        P207 p207 = new P207();
        System.out.println(p207.canFinish(2,nums));
    }

}
