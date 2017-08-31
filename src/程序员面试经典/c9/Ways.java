package 程序员面试经典.c9;

/**
 * Created by Administrator on 2017/3/21.
 * 有个小还
 */
public class Ways {
    static int [] map = new int[50];
    static int countWays(int n){
        if (n<0)
            return 0;
        else if (n==0)
            return 1;
        if (map[n]!=0)
            return map[n];
        map[n] = countWays(n-1)+countWays(n-2)+countWays(n-3);
        return map[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(30));
    }
}
