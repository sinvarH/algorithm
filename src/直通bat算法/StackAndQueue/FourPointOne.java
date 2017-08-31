package 直通bat算法.StackAndQueue;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * Created by Administrator on 2017/3/28.
 */
public class FourPointOne {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node){
        stackData.push(node);
        if(stackMin.isEmpty()){
            stackMin.push(node);
        }else if (node<=stackMin.peek()) {
            stackMin.push(node);
        }
    }

    public void pop(){
        int top = stackData.pop();
        if (top==stackMin.peek()){
            stackMin.pop();
        }
    }

    public int top(){
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}



