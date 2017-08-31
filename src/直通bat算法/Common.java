package 直通bat算法;

import 程序员面试经典.c2.ListNode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/16.
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。

 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 */
public class Common {
        public int[] findCommonParts(ListNode headA, ListNode headB) {
            // write code here
            ArrayList<Integer> list = new ArrayList<>();
            if(headA==null||headB==null)
                return null;

            while(headA!=null&&headB!=null){
                if(headA.val>headB.val)
                    headB = headB.next;
                else if(headA.val<headB.val)
                    headA = headA.next;
                else{
                    headA = headA.next;
                    headB = headB.next;
                    list.add(headA.val);
                }
            }
            int[] back = new int[list.size()];
            for (int i = 0 ;i<list.size();i++){
               back[i] = list.get(i);
             }
           return back;
        }
}
