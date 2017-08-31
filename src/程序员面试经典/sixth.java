package 程序员面试经典;

/**
 * Created by Administrator on 2017/3/12.
 */
public class sixth {
    public static int[][] transformImage(int[][] mat, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; ++i) {
                int offset = i - first;
                int top = mat[first][i]; // save top

                // left -> top
                mat[first][i] = mat[last-offset][first];

                // bottom -> left
                mat[last-offset][first] = mat[last][last - offset];

                // right -> bottom
                mat[last][last - offset] = mat[i][last];

                // top -> right
                mat[i][last] = top; // right <- saved top
            }
        }

        return mat;

    }

    public static int[][] transformImage2(int[][] mat, int n) {
       for (int layer = 0 ;layer<n/2 ;layer++){
           int first = layer;
           int last = n-1-layer;
           for (int i = first;i<last;i++){
               int offset = i - first;
               int top = mat [first][i];

               //左到上
               mat[first][i] = mat[last-offset][first];
               //下到左
               mat[last-offset][first] = mat[last][last-offset];
               //右到下
               mat[last][last-offset] = mat[i][last];
               //上到右
               mat[i][last] = top;

           }
       }
        return mat;
    }
//
//    public static void swap(int[][] mat,int a ,int b){
//        mat[a] = mat[]^b;
//        b = a^b;
//        a = a^b;
////        System.out.println(a+""+b);
//    }

    public static void logOut(int[][] mat,int n ){
        for (int i = 0 ;i<n ;i++){
            for(int j = 0;j<n;j++){
                System.out.println(mat[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        //swap(3,4);

        int [][] fuck = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        logOut(transformImage2(fuck,3),3);
//        logOut(fuck,3);
    }
}
