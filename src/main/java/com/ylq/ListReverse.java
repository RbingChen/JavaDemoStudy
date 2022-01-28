package com.ylq;

public class ListReverse {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        ListNode after =null;
        ListNode pre = null;
        //分奇偶节点，奇数：cur!=null;偶数：cur.next!=null
        while(cur != null && cur.next != null){
            after = cur.next;
            cur.next = head;

            head = after;
            pre = cur;
            cur = head.next;
            head.next = pre;
        }
        //偶数
        if(cur!=null){
            cur.next = head;
            return cur;
        }
        //奇数：
        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode node = reverseList(l1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
