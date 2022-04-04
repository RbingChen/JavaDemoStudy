package com.nextwork.leetcode;

import java.util.Iterator;
import java.util.List;

public class Print {
    public static void printIntArray(int t[]){
        if(t==null||t.length==0){
            System.out.println(" No element in Arayy, Please chekout program");
        }
        for(int i=0;i<t.length;i++){
            if(i==0){
                System.out.print("["+t[i]+",");
            }else if(i==t.length-1){
                System.out.println(t[i]+"]");
            }else{
                System.out.print(t[i]+",");
            }
        }
    }
    public static void printIntListNode(ListNode lt){
        while(lt!=null){
            System.out.print(lt.val+ " ");
            lt = lt.next;
        }
        System.out.println();
    }
    public static void printIntListListNode(List lt){
        Iterator<List> lit = lt.iterator();
        while(lit.hasNext()){
            List<Integer> li = lit.next();
            for(Integer i : li){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}

