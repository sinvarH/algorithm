import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 6/16/2017.
 */
public class NowCoder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] childs = new int[n];
        for (int i = 0 ;i<n;i++){
            childs[i] = sc.nextInt();
        }
        Arrays.sort(childs);
        if (n==3)
            System.out.println(childs[2]-childs[0]);
        int min = 0 ;
        int next = 1;
        int MinMax = childs[n-1]- childs[0];
        while (next<n-1){
            int c = childs[next+1]-childs[0];
            if (c<MinMax){
                MinMax = c;
                next++;
            }else {
                break;
            }
        }
        System.out.println(MinMax);

    }


}
