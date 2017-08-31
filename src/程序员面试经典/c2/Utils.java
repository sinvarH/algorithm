package 程序员面试经典.c2;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Utils {
    public  static void printLinkList(ListNode phead){
        while (phead!=null){
            System.out.println(phead.val);
            phead = phead.next;
        }
    }
}
