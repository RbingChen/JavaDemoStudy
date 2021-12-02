package ylq.leetcode;

import java.util.Scanner;

public class YcFirst {

    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        String s0 = reader.nextLine();
        String s1 = reader.nextLine();
        System.out.println(solution(s0,s1));
    }
    public static int parse(char c){
        return Integer.parseInt(String.valueOf(c));
    }
    public static String solution(String s0, String s1){
        if(s0==null || s0.length()==0) return s1;
        if(s1==null || s1.length()==0) return s0;
        String long_ = s0.length() >= s1.length() ? s0 : s1;
        String short_ = s0.length() < s1.length() ? s0 : s1;
        String result ="";
        int carry = 0;
        int i = 0;
        long_ = new StringBuilder(long_).reverse().toString();
        short_= new StringBuilder(short_).reverse().toString();
        for(;i<short_.length();i++){
            int tmp = parse(short_.charAt(i)) + parse(long_.charAt(i)) + carry;
            if(tmp==2){
                carry=1;
                result="0"+result;
            }else if(tmp==3){
                carry=1;
                result="1"+result;
            }else if(tmp==0){
                carry=0;
                result="0"+result;
            }else if(tmp==1){
                carry=0;
                result="1"+result;
            }
        }
        for(;i<long_.length();i++){
            int tmp = parse(long_.charAt(i)) +carry;
            if(tmp==2){
                carry=1;
                result="0"+result;
            }else if(tmp==3){
                carry=1;
                result="1"+result;
            }else if(tmp==0){
                carry=0;
                result="0"+result;
            }else if(tmp==1){
                carry=0;
                result="1"+result;
            }
        }
        if(carry!=0){
            result = "1"+result;
        }
        return result;
    }
}
