package 直通bat算法;

/**
 * Created by Administrator on 2017/3/31.
 */
public class Backpack {
    public static int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        int dp[] = new int[cap+1];
        for (int i=0 ;i<n;i++){
            for (int j = w[i];j<=cap;j++){
                dp[j] = Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
        return dp[cap];
    }
    public static int maxValue2(int[] w, int[] v, int n, int cap) {
        // write code here
        int [][] dp = new int[n][cap+1];
        //初始化
        for (int i = 0 ;i<=cap;i++){
            if (i>=w[0]){
                dp[0][i] = v[0];
            }
        }
        for (int i = 0 ;i<n;i++){
            dp[i][0] = 0;
        }

        for (int i =1;i<n;i++){
            for (int j=1;j<=cap;j++){
                if (j<w[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[n-1][cap];
    }



    public static void main(String[] args) {
        int [] fuck  = {1,2,3 };
        int [] fuck2 = {1,2,3,};
        System.out.println(maxValue(fuck,fuck2,3,6));
    }
}
