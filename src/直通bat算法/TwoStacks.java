package 直通bat算法;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/4/15.
 */
public class TwoStacks {
    private static Stack<Integer> stack = new Stack<>();
    public  static ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : numbers) {
            stack.push(i);
        }
        stack = sort(stack);
        arrayList.addAll(stack);
        return arrayList;
    }

    public static Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()){
            int current = stack.pop();
            if (temp.isEmpty()){
                temp.push(current);
            }else {
                //peek不删除pop弹出并删除
                while (!temp.isEmpty()&&temp.peek()<current){
                    stack.push(temp.pop());
                }
                temp.push(current);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int [] fuck = {1,2,3,4,5};
        System.out.println(twoStacksSort(fuck));
    }
}