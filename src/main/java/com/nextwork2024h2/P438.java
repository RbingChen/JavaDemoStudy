package com.nextwork2024h2;
import java.util.*;
/*
https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/9749/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/?envType=study-plan-v2&envId=top-100-liked
*/
public class P438 {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> need= new HashMap();
        Map<Character,Integer> windows= new HashMap();
        List<Integer> ret = new ArrayList();
        for(int i = 0;i<p.length();i++){
            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
        }
        int left =0 ,right =0 ;
        int valid =0 ;
        while(right<s.length()){
            char tmp = s.charAt(right);
            right++;
            if(need.containsKey(tmp)){
                windows.put(tmp,need.getOrDefault(tmp,0)+1);
                if(windows.get(tmp)==need.get(tmp)){
                    valid ++;
                }
            }
            while(right-left>=p.length()){
                if(valid==p.length() && right-left==p.length()){
                    ret.add(left);
                }
                char tmp2 = s.charAt(left);
                left ++;
                if(need.containsKey(tmp2)){
                    if(windows.get(tmp2)==need.get(tmp2)){
                        valid --;
                    }
                    windows.put(tmp2,need.get(tmp2)-1);
                }
            }
        }
        return ret;
    }
}
