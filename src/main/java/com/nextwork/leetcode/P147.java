package com.nextwork.leetcode;

public class P147 {

    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode dummy2 = new ListNode(-1);
        ListNode newHead = dummy2;
        while(head!=null){
            int min = head.val;
            ListNode tPre = pre;
            ListNode tSmall = head;

            ListNode cur = head;
            ListNode curPre = pre;
            while(cur!=null){
                if(cur.val <= min){
                    tSmall = cur;
                    tPre = curPre;
                }
                curPre = cur;
                cur = cur.next;
            }

            if(tSmall!=null && head==tSmall) {
                pre.next = head.next;
                head.next =null;
                head = pre.next;

            }else{
                tPre.next = tSmall.next;
                tSmall.next = null;
            }

            newHead.next = tSmall;
            newHead = tSmall;
            newHead.next = null;
        }
        return dummy2.next;
    }

    public static void main(String args[]){
        P147 p147 = new P147();
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);

        l1.next = l2;l2.next = l3;l3.next = l4;

        Print.printIntListNode(p147.insertionSortList(l1));

    }
}
