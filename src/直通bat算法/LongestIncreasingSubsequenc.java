package 直通bat算法;

/**
 * Created by Administrator on 2017/3/31.
 */
public class LongestIncreasingSubsequenc {
    public static int getLIS(int[] A, int n) {
        // write code herev
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i=1; i<n; i++){
            int max = 0;
            for (int j=0; j<i; j++){
                if (A[j]<A[i]){
                    max = dp[j]>max? dp[j]:max;
                }
            }
            dp[i] = max+1;
        }
        int arrayMax=0;
        for (int fuck: dp) {
            arrayMax = arrayMax< fuck? fuck:arrayMax;
        }
        return arrayMax;
    }

    public static void main(String[] args) {
        int[] fuck ={1,4,2,5,3,6,7,8,9,5,10};
        System.out.println(getLIS(fuck,11));

    }
}
