package 直通bat算法.StackAndQueue;


/**
 * Created by Administrator on 2017/4/16.
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。

 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。

 测试样例：
 {1,4,2,5},3
 {1,2,4,5}
 */
public class Divide {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    private ListNode former = new ListNode(0);
    private ListNode formerFirst = former;
    private ListNode middle = new ListNode(0);
    private ListNode middleFirst = middle;
    private ListNode latter = new ListNode(0);
    private ListNode latterFirst = latter;
    private ListNode mergeList = new ListNode(0);
    private ListNode mergeListFirst = new ListNode(0);
    public ListNode listDivide(ListNode head, int val) {
        if (head == null)
            return null;
        // 遍历链表
        while (head != null) {
            if (head.val < val) {
                former.next = new ListNode(head.val);
                former = former.next;
            } else if (head.val == val) {
                middle.next = new ListNode(head.val);
                middle = middle.next;
            } else {
                latter.next = new ListNode(head.val);
                latter = latter.next;
            }
            head = head.next;
        }


        if (formerFirst.next != null) {
            mergeListFirst = formerFirst;
            mergeList = former;
        }
        if (middleFirst.next != null) {
            if (formerFirst.next==null){
                mergeListFirst = middleFirst;
            }
            mergeList.next = middleFirst.next;
            mergeList = middle;
        }
        if (latterFirst.next != null) {
            if (formerFirst.next==null&&middleFirst.next==null){
                mergeListFirst = middleFirst;
            }
            mergeList.next = latterFirst.next;
        }
        System.out.println(mergeList.val);
        return mergeListFirst.next;
    }

    public static void main(String[] args) {
        Divide fuck = new Divide();
        int[] s = {360,220,2};
        Divide.ListNode fucku = new Divide.ListNode(360);
        fucku.next = new Divide.ListNode(220);
        fucku.next.next = new Divide.ListNode(2);
        fuck.listDivide(fucku,2);
    }
}