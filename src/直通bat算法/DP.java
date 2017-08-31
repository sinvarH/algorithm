package 直通bat算法;

import jdk.nashorn.internal.ir.IfNode;

/**
 * Created by Administrator on 2017/3/30.
 */
public class DP {
    public  static int countWays(int[] penny ,int index,int aim){
        if (penny==null||penny.length==0||aim<0){
            return 0;
        }
        int res = 0 ;
        if (index == penny.length){
            res = aim == 0 ? 1:0 ;
            return res;
        }else {
            for (int i = 0;penny[index]*i<=aim;i++){
                res += countWays(penny,index+1,aim-penny[index]*i);
            }
            return res;
        }
    }

    public  static int count(int[] penny ,int n,int aim) {
        return  countWays(penny,0,aim);
    }


    public static void main(String[] args) {
        int[] fuck = {1,2,4};

        System.out.println(countWaysDp(fuck,3,3));
    }


    //dp做法
    public static int countWaysDp(int[] penny,int n,int aim){
        int dp[][] = new int[51][1001];
        for(int i = 0;i<=aim;i++){
            for (int j=0;i-j*penny[0]>=0;j++){
                dp[1][j*penny[0]] = 1;
            }
        }

        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=aim;j++){
                for (int k = 0;j-k*penny[i-1]>=0;k++) {
                    dp[i][j] += dp[i - 1][j - k*penny[i-1]];
                }
            }
        }

        return dp[n][aim];

    }









}
