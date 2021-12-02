package com.cimon.leetcode.sword2offer;

import org.apache.commons.lang3.RandomUtils;

public class ReverseList {
    public  static ListNode solution(ListNode head){
        ListNode p = head;
        if (p.next == null)
            return p;
        ListNode pNext = p.next;
        p.next = null;
        while (pNext != null) {
            ListNode tmp = pNext.next;
            pNext.next = p;
            p = pNext;
            pNext = tmp;
        }
        return p;
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;l2.next = l3;
        ListNode t =  solution(l1);
        while(t.next!=null){
            System.out.println(t.val);
            t = t.next;
        }
        for(int i =0 ;i<1000;i++){
            System.out.println(RandomUtils.nextDouble(0,1));
        }
    }
}

