package 程序员面试经典.c2;

/**
 * Created by Administrator on 2017/3/14.
 * 2-5
 */
public class twelvfth {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if (a ==null)
            return b;
        if (b == null)
            return a;
        ListNode head = new ListNode(0);
        ListNode current = head;
        int sum = 0;
        boolean addOne = false;
        while (a!=null||b!=null||sum!=0){
            if (a!=null){
                sum += a.val;
                a = a.next;
            }
            if (b!=null){
                sum += b.val;
                b = b.next;
            }
            current.next = new ListNode(sum%10);
            sum /=10;
            current = current.next;
        }
        return head.next;

    }

}
