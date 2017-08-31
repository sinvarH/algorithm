package 剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 8/12/2017.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] data = new String[n];
        for (int i = 0;i<n;i++){
            data[i] = sc.next();
        }

        int total = 0;
        for (int i = 0;i<data.length;i++){
            total+= nums(data[i]);
        }
        System.out.println(total);
    }


    static int nums (String s){
        //存放dji的位置
        List<Integer> listD = new ArrayList<>();
        List<Integer> listJ = new ArrayList<>();
        List<Integer> listI = new ArrayList<>();
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)=='d')
                listD.add(i);
            else if (s.charAt(i)=='j')
                listJ.add(i);
            else if (s.charAt(i)=='i')
                listI.add(i);
        }
        int count = 0;
        for (int i = 0;i<listD.size();i++){
            for (int j = 0;j<listJ.size();j++){
                for (int k =0;k<listI.size();k++){
                    if (listD.get(i)<listJ.get(j)&&(listJ.get(j)<listI.get(k)))
                        count++;
                }
            }
        }
        return count;
    }

}
