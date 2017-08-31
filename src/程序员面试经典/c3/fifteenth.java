package 程序员面试经典.c3;

import java.util.Stack;
/**
 * Created by Administrator on 2017/3/15.
 * 两个栈实现队列
 */
public class fifteenth {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
