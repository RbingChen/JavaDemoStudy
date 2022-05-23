package com.nextwork.leetcode;

public class P148 {
    public ListNode sortList(ListNode head) {
        return partition(head);
    }
    public ListNode findMid(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode slow = head,fast=head;
        ListNode pre = slow;
        while(fast!=null){
            if(fast.next==null) break;
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next =null;
        return slow;
    }
    public ListNode partition(ListNode head){
        if(head==null || head.next ==null) return head;
        ListNode mid = findMid(head);
        ListNode node1 = partition(head);
        ListNode node2 = partition(mid);
        return merge(node1,node2);
    }
    public ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(node1!=null && node2!=null){
            if(node1.val > node2.val){
                cur.next = node2;
                node2=node2.next;
            }else{
                cur.next = node1;
                node1=node1.next;
            }
            cur = cur.next;
        }
        if(node1!=null) cur.next = node1;
        if(node2!=null) cur.next = node2;
        return dummy.next;
    }
    public static void main(String args[]){
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node.next = node1;node1.next = node2;node2.next = node3;
        P148 p148 = new P148();
        ListNode node33 = p148.sortList(node);
        Print.printIntListNode(node33);

    }
}
