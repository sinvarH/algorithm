package 程序员面试经典.c3;

import 程序员面试经典.Node;

/**
 * Created by Administrator on 2017/3/16.
 */
public class Queue {
    Node first,last;

    void enqueue(Object item){
        if (first==null){
            first = new Node(item);
            last = first;
        }else {
            last.next = new Node(item);
            last = last.next;
        }

    }

    Object dequeue(){
        if (first!=null){
            Object item =  first.data;
            first = first.next;
            return item;
        }
        return null;
    }
}
