package com.nextwork.leetcode;

public class P6 {
    public static String convert(String s, int numRows) {
        if(numRows==1 || s.length()==0) return s;
        String strArr[] = new String[numRows];
        for(int i =0;i<numRows;i++){
            strArr[i]="";
        }
        int row = 0;
        boolean flag = true;
        for(int i=0;i<s.length();i++){
            if(flag){
                strArr[row] += s.charAt(i);
                row ++ ;
                if(row == numRows) {
                    flag = false;
                    row = numRows -2;
                }
            }else{
                strArr[row] += s.charAt(i);
                row --;
                if(row<0){
                    flag = true;
                    row = 1;
                }
            }
        }
        String str = "";
        for(int i =0;i<numRows;i++){
            str+=strArr[i];
        }
        //System.out.println(str);
        return str;
    }
    public static void main(String args[]){
        System.out.println("PAHNAPLSIIGYIR".equals(convert("PAYPALISHIRING",3)));
        System.out.println("PINALSIGYAHRPI".equals(convert("PAYPALISHIRING",4)));
    }
}
