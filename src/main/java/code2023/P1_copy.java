package code2023;


import code2022.ListNode;

public class P1_copy {
    public static int solution(ListNode head){
        ListNode slowNode = head,fastNode = head;
        while(fastNode!=null&&fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(slowNode == fastNode){
                return 0;
            }
        }
        return 1;
    }
}
