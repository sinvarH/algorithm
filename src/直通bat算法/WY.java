package 直通bat算法;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/25.
 */
public class WY {
    public static void main(String[] args) {
        int[] loop ;
        int n = 0;
        int k = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            loop = new int[n];
            k = scanner.nextInt();

            for (int i = 0; i<n ;i++){
                loop[i] = scanner.nextInt();
            }

            for(int i = 0;i<k;i++){
                int first = loop[0];
                for (int j = 0; j<n;j++){
                    if (j==n-1){
                        loop[j] = loop[j]+first;
                    }else {
                        loop[j] = loop[j] + loop[j + 1];
                    }
                    if (loop[j]>=100){
                        loop[j] = loop[j]%100;
                    }
                }
            }

            StringBuffer stringBuffer = new StringBuffer();
           for (int i = 0 ;i<n;i++){
               if (i!=n-1) {
                   stringBuffer.append(loop[i]);
                   stringBuffer.append(" ");
               }else {
                   stringBuffer.append(loop[i]);
               }
           }
            System.out.println(stringBuffer.toString());
        }
    }



}
