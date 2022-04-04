package com.nextwork.leetcode;

/**
 * 2022-03-30 20:56
 * */
public class P2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1==null) return l2;
       if(l2==null) return l1;
       int carry = 0;
       ListNode head = new ListNode(-1);
       ListNode re = head;
       while(l1!=null && l2!=null){
           int sum = l1.val + l2.val+carry;
           if(sum>=10){
               sum = sum%10;
               carry = 1;
           }else{
               carry = 0;
           }
           head.next = new ListNode(sum);
           head = head.next;
           l1 = l1.next;
           l2 = l2.next;
       }
       if(l1==null){
          support(l2,head,carry);
       }
       if(l2==null){
           support(l1,head,carry);
       }
       return re.next;
    }
    private static void support(ListNode ln, ListNode head, int carry){
        while(ln!=null){
            int sum =  ln.val+carry;
            if(sum>=10){
                sum = sum%10;
                carry = 1;
            }else{
                carry = 0;
            }
            head.next = new ListNode(sum);
            head = head.next;
            ln = ln.next;
        }
        if(carry > 0){
            head.next = new ListNode(carry);
        }

    }
    public static void main(String args[]){
       ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode t = addTwoNumbers(l1,l2);
        Print.printIntListNode(t);
    }
}
