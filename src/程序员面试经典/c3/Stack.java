package 程序员面试经典.c3;

import 程序员面试经典.Node;

/**
 * Created by Administrator on 2017/3/15.
 */
public class Stack {
    Node top ;

    Object pop(){
        if (top!=null){
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void  push(Object item){
        Node t = new Node(item);
        t.next = top;
        top = t ;
    }

    Object peek(){
        return top.data;
    }


}
