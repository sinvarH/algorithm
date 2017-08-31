package 直通bat算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2017/4/15.
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。

 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 */
public class TwoStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public int[] twoStack(int[] ope, int n) {
        // write code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ;i<n; i++){
            if (i==0 &&ope[0] == 0){
                return null;
            }

            if (ope[i]==0){
                list.add(pop());
            }else {
                push(ope[i]);
            }
        }

        int []  fuck = new int[list.size()];
        for (int i =0 ; i<list.size();i++) {
            fuck[i] = list.get(i);
        }
        return fuck;
    }

    private void push(int data){
        stack1.push(data);
    }

    private int pop(){
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()&&stack1.empty())
            return 0;
        return stack2.pop();
    }

    public static void main(String[] args) {

    }
}
