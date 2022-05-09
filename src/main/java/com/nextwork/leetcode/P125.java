package com.nextwork.leetcode;

public class P125 {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if('a'<=ch && ch<='z') sb.append(ch);
        }
        String ret = sb.reverse().toString();
        String pr = sb.toString();
        return ret.equals(pr);
    }
    public static void main(String args[]){
        P125 p125 = new P125();
        String t = "2";
        String b = "10";
        System.out.println(t.compareTo(b));
        System.out.println(p125.isPalindrome("OP"));
    }
}
