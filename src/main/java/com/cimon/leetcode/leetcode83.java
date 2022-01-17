package com.cimon.leetcode;

public class leetcode83 {
    public static void main(String[] args) {
        ListNode lt = new ListNode(1);
        lt.next = new ListNode(1);
        lt.next.next = new ListNode(2);
        lt.next.next.next = new ListNode(3);
        lt.next.next.next.next = new ListNode(3);
        ListNode node  = deleteDuplicates(lt);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }
    public static ListNode deleteDuplicates(ListNode head){
        ListNode lt = head;
        while (lt != null && lt.next !=null){
            if(lt.val == lt.next.val){
                lt.next = lt.next.next;
            }else{
                lt = lt.next;
            }
        }
        return head;
    }


}
