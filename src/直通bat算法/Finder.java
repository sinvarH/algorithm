package 直通bat算法;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/12.
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。

 给定一个字符串A及它的长度n，请子返回它的最长无重复字符串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 */
public class Finder {
    public static boolean findX(int[][] mat, int n, int m, int x) {
        // write code here
        int row = 0;

        for (int i=0 ;i<n;i++){
           if (mat[i][m-1]<x){
               row++;
           }
        }
        if (row>n-1)
            return false;
        for(int i=m-1;i>=0;i--){
            if (mat[row][i]==x){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] fuck = {{1,2,3},{4,5,6},{7,8,9}};
        Scanner sc = new Scanner(System.in);
        String a ="fuck";
        String b = new String("fuck");
        System.out.println(findX(fuck,3,3,5));
        System.out.println(a.equals(b));
        Object o = new Object();

    }
}