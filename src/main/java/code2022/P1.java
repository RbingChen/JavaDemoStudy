package code2022;


public class P1 {
    public static int soltuion(ListNode head){
        ListNode walker = head;
        ListNode runner = head;
        while(runner!=null&&runner.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner){
                return 0;
            }
        }
        return 1;
    }
}
