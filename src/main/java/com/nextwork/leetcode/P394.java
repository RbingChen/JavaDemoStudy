package com.nextwork.leetcode;

import java.util.Stack;

public class P394 {
    int ptr;
    public String decodeString(String s){
        ptr =0;
        Stack<String> st = new Stack();
        while(ptr<s.length()){
            char cur = s.charAt(ptr);
            if(Character.isDigit(cur)){
                st.push(getDigits(s));
            }else if(Character.isLetter(cur)){
                st.push(getString(s));
            }else if(cur=='['){
                st.push(String.valueOf(cur));
                ptr++;
            }else{
                /// cur==']'
                ptr++;
                String str = "";
                while(!"[".equals(st.peek())){
                    str= st.pop() + str;
                }
                st.pop();// ]
                int count = Integer.valueOf(st.pop());
                StringBuilder sb = new StringBuilder();
                while(count-->0){
                    sb.append(str);
                }
                st.push(sb.toString());
            }
        }
        return getRes(st);
    }

    public String getDigits(String s){
        StringBuilder sb = new StringBuilder();
        while(Character.isDigit(s.charAt(ptr))){
            sb.append(s.charAt(ptr++));
        }
        return sb.toString();
    }
    public String getString(String s){
        StringBuilder sb = new StringBuilder();
        while(Character.isLetter(s.charAt(ptr))){
            sb.append(s.charAt(ptr++));
        }
        return sb.toString();
    }
    public String getRes(Stack<String> st){
        String str = "";
        while(!st.isEmpty()){
            str= st.pop() + str;
        }
        return str;
    }
    public static void main(String args[]){
        P394 p394 = new P394();
        System.out.println(p394.decodeString("2[er3[c]]"));
    }
}
