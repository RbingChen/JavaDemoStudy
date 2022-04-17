package com.nextwork.leetcode;

public class P82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode now = head;
        ListNode next= head.next;
        while(next!=null){

            if(now.val == next.val){
                while(next!=null && now.val==next.val){
                      next = next.next;
                }
                pre.next = next;
                if(pre.next ==null) return dummy.next;
                now = pre.next;
                next = pre.next.next;
            }else{
                pre = now;
                now = next;
                next = next.next;
            }

        }
        return dummy.next;
    }
    public static void main(String args[]){

    }
}
