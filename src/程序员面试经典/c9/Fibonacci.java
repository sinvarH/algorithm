package 程序员面试经典.c9;

/**
 * Created by Administrator on 2017/3/21.
 */
public class Fibonacci {
    static long [] fib = new long[51];
    static long fibonacci(int i ){
        if (i == 0)
            return 0;
        if (i==1)
            return 1;
        if (fib[i]!=0)
            return fib[i];
        fib[i] = fibonacci(i-1)+fibonacci(i-2);
        return fib[i];
    }


    public static void main(String[] args) {
        System.out.println(fibonacci(50));
    }
}
