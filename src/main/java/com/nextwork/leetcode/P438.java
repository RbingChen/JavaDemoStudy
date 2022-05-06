package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> lt = new ArrayList();
        Map<Character,Integer> map = new HashMap();
        for(int i = 0;i<p.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        int lenP = p.length();
        int left=0,right=0;
        Map<Character,Integer> slide = new HashMap();
        int count=lenP;
        while(left<=right && right<=s.length()){
            if(count>0 && right<s.length()){
                char cur = s.charAt(right++);
                if(map.containsKey(cur)){
                    if(slide.getOrDefault(cur,0)< map.get(cur)){
                        count--;
                    }
                }
                slide.put(cur,slide.getOrDefault(cur,0)+1);
            }else{
                if(right-left== lenP && count==0){
                    lt.add(left);
                }
                if(left>=s.length()) break;
                char cur = s.charAt(left++);
                if(map.containsKey(cur)){
                    if(slide.get(cur)<=map.get(cur)){
                        count++;
                    }
                }
                slide.put(cur,slide.get(cur)-1);
            }
        }
        return lt;
    }
    public static void main(String args[]){
        P438 p438 = new P438();
        List<Integer> lt = p438.findAnagrams("cbaebabacd","abc");
        for(int t : lt){
            System.out.println(t);
        }
    }
}
