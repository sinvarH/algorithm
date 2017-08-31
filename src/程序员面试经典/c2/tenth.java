package 程序员面试经典.c2;

/**
 * Created by Administrator on 2017/3/13.
 */
public class tenth {
    public boolean removeNode(ListNode pNode) {
        // write code here
        if (pNode==null||pNode.next==null){
            return false;
        }else {
            pNode = pNode.next;
            return true;
        }
    }
}
