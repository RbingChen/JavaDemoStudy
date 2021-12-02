package com.cimon.leetcode;


public class p21 {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode node = mergeTwoLists(l1 , l2);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(-1);
        ListNode preNode = headNode;
        while (l1!=null && l2!=null ){
            if (l1.val<l2.val){
                preNode.next = l1;
                l1 = l1.next;
            }else{
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1==null ? l2 : l1;
        return headNode.next;
    }
}
