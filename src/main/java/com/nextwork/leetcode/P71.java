package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P71 {
    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        List<String> list = new ArrayList();
        for(int i=0;i<arr.length;i++){
            String t = arr[i];
            if(t.equals("/")||t.equals(".")||t==null||t.length()==0){
                continue;
            } else if(t.equals("..")) {
                if (!list.isEmpty()) list.remove(list.size() - 1);
            }
            else {
                list.add(t);
            }

        }
        if(list.isEmpty()) return "/";
        String res ="";
        for(String str : list){
            res+="/"+str;
        }
        return res;
    }
    public static void main(String args[]){
        P71 p71 = new P71();
        System.out.println(p71.simplifyPath("/home/"));
        System.out.println(p71.simplifyPath("/a/./b/../../c/"));
    }
}
