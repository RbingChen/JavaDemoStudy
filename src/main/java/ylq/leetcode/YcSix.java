package ylq.leetcode;

import java.util.Scanner;

public class YcSix {
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        System.out.println(sucessPair(str));
    }
    public static int sucessPair(String str){
        if(str.length()<=1) return 0;
        int count =0;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==')'&&str.charAt(i-1)=='('){
                count++;
                i+=1;
            }else if(str.charAt(i)=='('&&str.charAt(i-1)==')') {
                count++;
                i+=1;
            }
        }
        return count*2;
    }
}
