package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P93 {
    List<String> res = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0,"",0);
        return res;
    }

    public void backTrack(String s, int begin,String str,int count){
        if(begin==s.length()&& count==4){
            res.add(str.substring(1));
            return;
        }
        if(count==4 && begin<s.length()) return;

        for(int j=1;j<=3;j++){
            if(begin+j>s.length()) continue;
            if(s.charAt(begin)=='0' && j>1) continue;
            String tmp = s.substring(begin,begin+j);
            if(Integer.valueOf(tmp)>255) {
                continue;
                // 注意 字符 "3" 比 255 大
            }
            String next = str+"."+tmp;
            backTrack(s,begin+j,next,count+1);
        }

    }
    void print(List<String> lists){
        for(String str : lists){
            System.out.println(str);
        }
    }
    public static void main(String args[]){
        P93 p93 = new P93();
        p93.print(p93.restoreIpAddresses("25525511135"));
        p93.print(p93.restoreIpAddresses("101023"));
    }
}
