package com.nextwork.leetcode;

public class P61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int len =0;
        ListNode tmp = head;
        ListNode end = head;
        while(tmp!=null){
            len++;
            end = tmp;
            tmp = tmp.next;
        }

        k = k%len;
        if(k==0) return head;

        int niK = len - k;
        int count =0;
        tmp = head;

        while(tmp!=null){
            count++;
            if(count==niK) break;
            tmp = tmp.next;
        }
        ListNode res = tmp.next;
        tmp.next = null;
        end.next = head;
        return res;
    }
    public static void main(String args[]) {
        P61 p61 = new P61();
    }
}
