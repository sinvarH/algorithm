package 直通bat算法;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/2.
 */
public class NowCoder {
    public static void MinTime(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] length = new int[n];
        for (int i = 0;i<n ;i++){
            length [i] = scanner.nextInt();
        }
        int sum = 0 ;
        int[] length2  = new  int[n+1];
        for(int i = 0 ;i<n;i++){
            sum += length[i]/1024;
            length2[i+1] = length[i]/1024;
        }
        int[][] dp = new int[n+1][sum/2+1];
        for (int i = 1;i<=n;i++){
            for (int j =1 ;j<=sum/2;j++){
                if (j<length2[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-length2[i]]+length2[i]);
                }
            }
        }
        System.out.println((sum-dp[n][sum/2])*1024);

    }

    public static void main(String[] args) {
//        MinTime();
        Scanner sc = new Scanner(System.in);
        int gx = sc.nextInt();
        int gy = sc.nextInt();
    }

}
