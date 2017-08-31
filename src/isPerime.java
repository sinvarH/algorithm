/**
 * Created by Administrator on 2017/2/13.
 */
public class isPerime {
    public static void main(String[] args) {
        System.out.println(isperime(7));
    }

    public static boolean isperime(int n){
        if (n<2) return true;
        for (int i=2;i*i<n;i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
}
