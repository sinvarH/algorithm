package 程序员面试经典.c2;

import java.util.Stack;

/**
 * Created by Administrator on 2017/3/14.
 */
public class thirteen {
    //    public ListNode plusAB(ListNode a, ListNode b) {
//        // write code here
//
//    }
    public static boolean isPalindrome(ListNode pHead) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;
        Stack<Integer> stack = new Stack<>();
        while (fast!=null&&fast.next!=null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast!= null){
            slow = slow.next;
        }
        while (slow!=null){
            if (stack.pop()!=slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(2);
        linkList.add(1);
        System.out.println(isPalindrome(linkList.head));
    }
}
