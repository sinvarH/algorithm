package 直通bat算法;

/**
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007

 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * Created by Administrator on 2017/3/30.
 */
public class GoUpstairs {
    public static int count(int n ){
        if (n <=0){
            return 0;
        }
        if (n ==1){
            return 1;
        }else if (n==2){
            return 2;
        }else{
//            return count(n-1)+count(n-2)%1000000007;
            int total = 0;
            int temp1 = 1;
            int temp2 = 2;
            for(int i=3;i<=n;i++){
                total = (temp1+temp2)%1000000007;
                temp1 = temp2;
                temp2 = total;
            }
            return total;
        }
    }

    public static void main(String[] args) {
        System.out.println(count(10));
    }
}
