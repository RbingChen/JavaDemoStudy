package com.nextwork.leetcode;

public class P92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        if(head==null|| head.next==null) return head;

        int count = 0;
        ListNode tmp = head;

        ListNode leftPre = new ListNode(-1);
        leftPre.next = head;
        ListNode tmpPre = leftPre,dummy = leftPre;
        ListNode rightNext = null;
        ListNode leftBegin = null;
        ListNode rightBegin = null;

        while(tmp!=null){
            count++;
            if(count==left) {
                leftPre = tmpPre;
                leftBegin = tmp;
            }
            if(count==right){
                rightBegin = tmp;
                rightNext = tmp.next;
                break;
            }
            tmpPre = tmp;
            tmp = tmp.next;
        }
        rightBegin.next = null;
        ListNode la[] = reverseList(leftBegin);
        leftPre.next = la[1];
        la[0].next = rightNext;
        return dummy.next;
    }
    public ListNode[] reverseList(ListNode head){
        ListNode [] la = new ListNode[2];
        ListNode pre = head;
        ListNode now = head.next;
        la[0] = head;
        head.next =null;
        while(now!=null){
            ListNode tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;

        }
        la[1] =pre;
        return la;
    }
    public ListNode reverseBetweenV2(ListNode head, int left, int right) {
        if(left==right) return head;
        if(head==null|| head.next==null) return head;

        int count = 0;
        ListNode tmp = head;

        ListNode leftPre = new ListNode(-1);
        leftPre.next = head;
        ListNode tmpPre = leftPre,dummy = leftPre;
        ListNode rightNext = null;
        ListNode leftBegin = null;
        ListNode rightBegin = null;

        while(tmp!=null){
            count++;
            if(count==left) {
                leftPre = tmpPre;
                leftBegin = tmp;
            }
            if(count==right){
                rightBegin = tmp;
                rightNext = tmp.next;
                break;
            }
            tmpPre = tmp;
            tmp = tmp.next;
        }
        rightBegin.next = null;
        reverseListV2(leftBegin);
        leftPre.next = rightBegin;
        leftBegin.next = rightNext;
        return dummy.next;
    }
    public void reverseListV2(ListNode head){

        ListNode pre = null;
        ListNode now = head;
        while(now!=null){
            ListNode tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;
        }
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        P92 p92 = new P92();
        Print.printIntListNode(p92.reverseBetweenV2(l1,1,2));
    }
}
