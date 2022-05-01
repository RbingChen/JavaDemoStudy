package com.nextwork.leetcode;

public class P23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int left ,int right){
        if(left==right) return lists[left];
        if(left>right) return null;

        int mid = (left+right)/2;
        return mergeTwoList(merge(lists,left,mid),merge(lists,mid+1,right));

    }

    public ListNode mergeTwoList(ListNode lt1,ListNode lt2){
        if(lt1==null && lt2==null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(lt1!=null && lt2!=null){

            if(lt1.val < lt2.val){
                pre.next = lt1;
                lt1 = lt1.next;
            }else{
                pre.next = lt2;
                lt2 = lt2.next;
            }
            pre = pre.next;
        }
        if(lt1!=null) pre.next = lt1;
        if(lt2!=null) pre.next = lt2;
        return dummy.next;
    }
    public static void main(String args[]){
        ListNode lt = new ListNode(1);
        ListNode lt1 = new ListNode(4);
        ListNode lt2 = new ListNode(5);
        lt.next =lt1; lt1.next = lt2;
        ListNode lt3 = new ListNode(2);

        ListNode lt4 = new ListNode(6);
        lt3.next = lt4;

        P23 p23 = new P23();
        Print.printIntListNode(p23.mergeTwoList(lt2,lt3));

    }
}
