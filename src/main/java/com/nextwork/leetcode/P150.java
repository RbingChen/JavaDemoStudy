package com.nextwork.leetcode;

import java.util.Stack;

public class P150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        for(String str : tokens){
            if(str.equals("+")){
                st.push(st.pop()+st.pop());
            }else if(str.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }else if(str.equals("*")){
                st.push(st.pop()*st.pop());
            }else if(str.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }else{
                st.push(Integer.valueOf(str));
            }
        }
        return st.pop();
    }

    public static void main(String args[]) {
         String strs[]= new String[]{"4","13","5","/","+"};
         P150 p150 = new P150();
         System.out.println(p150.evalRPN(strs));
    }

}
