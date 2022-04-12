package com.nextwork.leetcode;

public class P58 {
    public int lengthOfLastWord(String s) {
       String tmp = s.trim();
       String sArry[] = s.split("\\s+");
//       for(int i = sArry.length-1;i>=0;i--){
//
//       }
        return sArry[sArry.length-1].length();
    }
    public static void main(String args[]){
        P58 p58 = new P58();
        System.out.println(p58.lengthOfLastWord("Hello World"));
        System.out.println(p58.lengthOfLastWord("   fly me   to   the moon  "));

    }
}
