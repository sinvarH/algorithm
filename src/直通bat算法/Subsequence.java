package 直通bat算法;

/**
 * Created by Administrator on 2017/4/12.
 */
public class Subsequence {
    public static int shortestSubsequence(int[] A, int n) {
        // write code here
        int min = A[n-1];
        int minNum = 0;
        int max = A[0];
        int maxNum = 0;
        for (int i=1 ;i<n;i++){
            if (A[i]>=max){
                max = A[i];
            }else{
                maxNum = i;
            }
        }
        for (int i = n-2;i>=0;i--){
            if (A[i]<=min){
                min = A[i];
            }else {
                minNum = i;
            }
        }

        if (minNum!=maxNum)
        return maxNum-minNum+1;
        return 0;
    }

    public static void main(String[] args) {
        int [] fuck = {1,2,3,3,8,9};
        System.out.println(shortestSubsequence(fuck,6));
    }
}
