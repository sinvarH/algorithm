package 直通bat算法;

import java.util.Stack;

/**
 * Created by Administrator on 2017/4/15.
 */
public class StackReverse {
    public static int[] reverseStack(int[] A, int n) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        for (int i : A) {
            stack.push(i);
        }
        reverse(stack);
        for (int i = n-1;i>=0;i--){
            int fuck = stack.pop();
            A[i] = fuck;
        }
        return A;
    }
    public static int get(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.empty()){
            return result;
        }else {
            int last = get(stack);
            stack.push(result);
            return last;
        }
    }
    public static  void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = get(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        int[] fuck  = {230,272,224,399,126};
        reverseStack(fuck,5);
    }
}