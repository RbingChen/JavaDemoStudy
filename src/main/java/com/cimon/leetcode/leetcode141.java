package com.cimon.leetcode;
import com.cimon.leetcode.structure.ListNode;

public class leetcode141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(2);
        head.next = head1;
        head1.next = new ListNode(0);
        ListNode wei = new ListNode(-4);
        head1.next.next = wei;
        wei.next = head1;
        hasCycle(head);
        System.out.println(hasCycle(head));

    }
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next ==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
