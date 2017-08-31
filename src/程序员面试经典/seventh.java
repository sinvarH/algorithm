package 程序员面试经典;

/**
 * Created by Administrator on 2017/3/13.
 */
public class seventh {
    public int[][] clearZero(int[][] mat, int n) {
        // write code here
        boolean [] rowhaszero = new boolean[n];
        boolean [] clomunhaszero = new  boolean[n];
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                if (mat[i][j]==0){
                    rowhaszero[i] = true;
                    clomunhaszero[j] = true;
                }
            }
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                if (rowhaszero[i]||clomunhaszero[j]){
                        mat[i][j] = 0 ;
                }
            }
        }
        return mat;
    }
}
