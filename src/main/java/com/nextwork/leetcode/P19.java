package com.nextwork.leetcode;
/*
 *  2022 - 04 - 04 23:25
 * */
public class P19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode node = head;
       int len = 0;
       while(node!=null){
           len++;
           node=node.next;
       }
       ListNode pre = new ListNode();
       pre.next = head;
       ListNode now = pre;

       for(int i = 1; i < len-n+1 ;i++){
           now = now.next;
       }
       now.next = now.next.next;
       return pre.next;
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        Print.printIntListNode(removeNthFromEnd(l1,2));

    }

}
