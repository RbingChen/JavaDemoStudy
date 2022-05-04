package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P131 {
    List<List<String>> res = new ArrayList();
    List<String> lt = new ArrayList();
    public List<List<String>> partition(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        for(int i=0;i<s.length();i++) dp[i][i] = true;
        for(int len=2;len<=s.length();len++){
            for(int i=0;i<s.length();i++){
                int j=i+len-1;
                if(j>=s.length()) break;
                if(s.charAt(i)==s.charAt(j)){
                    if(len==2) {
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }
        backTrack(s,dp,0);
        return res;
    }
    public void backTrack(String s,boolean dp[][],int begin){
        if(begin==s.length()){
            res.add(new ArrayList(lt));
            return;
        }
        if(begin>s.length()) return;
        for(int j=begin;j<s.length();j++){
            if(dp[begin][j]){
                String tmp = s.substring(begin,j+1);
                lt.add(tmp);
                backTrack(s,dp,j+1);
                lt.remove(lt.size()-1);
            }
        }

    }
    void print(List<List<String>> lt){
        for(List<String> t : lt){
            for(String str : t){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        P131 p131 = new P131();

        p131.print(p131.partition("aa"));
    }
}
