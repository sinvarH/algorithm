package 直通bat算法;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/4/12.
 * 荷兰国旗问题
 */
public class helanguoqi {
    public static void main(String[] args) {
        int[] A = {1,2,0,2};
//        swap(A,1,2);
        System.out.println(Arrays.toString(sortThreeColor(A,4)));
        System.out.println(Arrays.toString(A));
    }

    public static int[] sortThreeColor(int[] A, int n) {
        // write code here
        int first = 0;
        int end = n-1;
        int current = 0 ;
        while (current<=end){
            if(A[current]==0){
                swap(A,current,first);
                current++;
                first++;
            }else if(A[current]==2){
                swap(A,current,end);
                end--;
            }else{
                current++;
            }
        }
        return A;
    }

    public static void swap(int []A ,int a,int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp ;
    }
}
