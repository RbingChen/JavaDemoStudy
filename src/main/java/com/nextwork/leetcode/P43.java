package com.nextwork.leetcode;

public class P43 {
    public String multiply(String num1, String num2) {
        String result = "0";
        String followZeros ="";
        for(int n=num2.length()-1; n>=0; n--){
            char b = num2.charAt(n);
            if(b!='0') {
                String t = oneMultiply(b,num1);
                t+=followZeros;
                result = bigPlus(result,t);
            }
            followZeros+='0';
        }
        while(result.length()>1 && result.charAt(0)=='0'){
            result = result.substring(1);
        }
     return result;
    }
    public String oneMultiply(char b ,String num){
        int carry = 0;
        String res = "";
        for(int n = num.length()-1;n>=0;n--){
            int  tmp =(b-'0') * (num.charAt(n)-'0')+carry;
            carry = tmp/10;
            int left = tmp%10;
            res=(char)(left+'0')+res;
        }
        if(carry>0) return (char)(carry+'0')+res;
        return res;
    }
    public String bigPlus(String num1,String num2){
       int n1 = num1.length()-1;
       int n2 = num2.length()-1;
       int carry = 0;
       String res = "";
       while(n1>=0 && n2>=0){
           int tmp = (num1.charAt(n1)-'0')+(num2.charAt(n2)-'0')+carry;
           n1--;n2--;
           carry = tmp/10;
           res= tmp%10+res;
       }
       while(n1>=0){
           int tmp = (num1.charAt(n1)-'0')+carry;
           n1--;
           carry = tmp/10;
           res= tmp%10+res;
       }
        while(n2>=0){
            int tmp = (num2.charAt(n2)-'0')+carry;
            n2--;
            carry = tmp/10;
            res= tmp%10+res;
        }
        if(carry>0) return (char)(carry+'0')+res;
        return res;
    }
    public static void main(String args[]){
      P43 p43 = new P43();
      System.out.println(p43.multiply("9","9"));
        System.out.println(p43.multiply("123","456"));

    }

}
