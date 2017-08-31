package 直通bat算法;

/**
 * Created by Administrator on 2017/3/31.
 */
public class MinimumPath {
    public static int getMin(int[][] map,int n,int m ){
        if (map == null)
            return 0;
        int [][] dp = new int[n][m];
        dp[0][0] = map[0][0];
        for(int i=1;i<n;i++){
            dp[i][0] =map[i][0]+ dp[i-1][0];
        }
        for(int i=1;i<m;i++){
            dp[0][i] =map[0][i]+ dp[0][i-1];
        }
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+map[i][j];
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] fuck = new int[4][];
        fuck[0] = new int[]{613, 0, 93, 463};
        fuck[1] = new int[]{101,369,112,255};
        fuck[2] = new int[]{42,67,86,543};
        fuck[3] = new int[]{485,452,393,461};
        System.out.println(getMin(fuck,4,4));
    }
}
