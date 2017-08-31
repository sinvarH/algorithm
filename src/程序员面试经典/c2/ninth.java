package 程序员面试经典.c2;

/**
 * Created by Administrator on 2017/3/13.
 */
public class ninth {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null&&k<=0){
            return null;
        }
        ListNode h1 = head;
        ListNode h2 = head;
        try {
            for (int i = 1;i<k;i++){
                if (h1.next!= null){
                    h1 = h1.next;
                }else {
                    return null;
                }
            }
        }catch (NullPointerException e){
            return null;
        }


        while (h1.next!=null){
            h1 = h1.next;
            h2 = h2.next;
        }
        return h2;
    }

}
