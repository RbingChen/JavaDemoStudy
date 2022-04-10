package com.nextwork.leetcode;
/*
 *  2022 - 04 - 05 13:25
 * */
public class P24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            ListNode  next_ = cur.next; // 保存下一跳
            ListNode  newCur  = next_.next; // 下下跳作为新Cur
            pre.next = next_; // 翻转开始
            next_.next = cur ;
            cur.next = newCur;
            pre = cur ;
            cur = newCur;
        }
       return dummy.next;
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        //l1.next.next.next.next = new ListNode(5);
        Print.printIntListNode(swapPairs(l1));

    }
}
