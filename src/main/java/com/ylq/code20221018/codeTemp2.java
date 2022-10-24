package com.ylq.code20221018;
import java.util.Scanner;

// 数组输入模版,输出模版
public class codeTemp2 {
    public static int[] coupons(int[] n,int[] k){
        //  算法 实现
        return n;
    }
    public static void main(String[] args){
        //输入
        Scanner reader= new Scanner(System.in);
        int num = reader.nextInt();
        int []n = new int[num];
        int []k = new int[num];
        int i = 0;
        while(reader.hasNext()){
            n[i] = reader.nextInt();
            k[i++] = reader.nextInt();
            if(i == n.length) break;
        }

        // 算法
        int [] result = coupons(n,k);
        // 结果输出
        for(int re : result){
             System.out.println(re);
        }
    }
}
