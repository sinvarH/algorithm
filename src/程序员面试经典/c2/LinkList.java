package 程序员面试经典.c2;

/**
 * Created by Administrator on 2017/3/14.
 */
public class LinkList {
    //单向链表
    ListNode head ;
    ListNode last;
    void add(int data){
        if (head==null){
            head = new ListNode(data);
            last = head;
        }else {
            ListNode node = new ListNode(data);
//            while (current.next!=null){
//                current = current.next;
//            }
            last.next = node;
            last = last.next;
        }
    }

    //移除最后一个
    void remove(){
        ListNode node = head ;
        if (head.next==null){
            head = null;
            return;
        }
        while (node.next.next!=null){
            node = node.next;
        }
        node.next = null;
    }
    void print(){
        ListNode node = head;
        if(node!=null){
            do {
                System.out.println(node.val);
                node = node.next;
            }while (node!=null);
        }
    }
}
