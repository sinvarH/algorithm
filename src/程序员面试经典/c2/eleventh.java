package 程序员面试经典.c2;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/3/13.
 */
public abstract  class eleventh {
    private static int x=100;
    public static void main(String[] args) throws UnsupportedEncodingException {
        LinkList ll = new LinkList();
        ll.add(1);
        ll.add(0);
        ll.add(2);
        ll.add(5);
        ll.add(3);
        ll.add(4);

        print(partition2(ll.head,4));

    }
    public static void print(ListNode node){
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static ListNode partition(ListNode node, int x) {
        // write code here
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
		
		/* Partition list */
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if (node.val < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }
		
		/* Merge before list and after list */
        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static ListNode partition2(ListNode pHead, int x) {
        // write code here
        if(pHead==null){
            return null;
        }
        ListNode smallStart = null;
        ListNode smallEnd = null;
        ListNode bigStart = null;
        ListNode bigEnd = null;

        while (pHead!=null){
            ListNode next = pHead.next;
            pHead.next = null;
            if (pHead.val<x){
                if (smallStart==null){
                    smallStart=pHead;
                    smallEnd=pHead;
                }else {
                    smallEnd.next = pHead;
                    smallEnd = smallEnd.next;
                }

            } else {
                if (bigStart==null){
                    bigStart = pHead;
                    bigEnd = pHead;
                }else {
                    bigEnd.next = pHead;
                    bigEnd = bigEnd.next;
                }
            }

            pHead = next;
        }

        if (smallEnd==null){
            return bigStart;
        }
        smallEnd.next = bigStart;
        return smallStart;
    }

}
