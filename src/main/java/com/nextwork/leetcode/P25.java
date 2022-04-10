package com.nextwork.leetcode;

import java.util.Stack;

/*
 *  2022 - 04 - 05 15:25
 * */
public class P25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode pre = dummy;
       ListNode cur = head;
       ListNode end = head;

       while(end!=null){
           for(int i=1;i<k && end!=null;i++){
               end = end.next;
           }
           if(end==null) break;
           ListNode newPre = cur;
           ListNode newCur = end.next;
           end.next = null;
           pre.next = reverseList(cur);
           newPre.next = newCur;
           cur = newCur;
           pre = newPre;
           end = newCur;
       }
       return dummy.next;
    }
    public static ListNode reverseList(ListNode cur){
        ListNode pre = null;
        while(cur!=null){
            ListNode nt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nt;
        }
        return pre;
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        Print.printIntListNode(reverseKGroup(l1,3));
    }

}
