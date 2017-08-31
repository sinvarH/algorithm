package 程序员面试经典;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        输入描述:
//
//        输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50)
//        第二行为序列中的n个整数item[i]  (1 ≤ iteam[i] ≤ 1000)，以空格分隔。
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            int n = scanner.nextInt();
//            int []  item = new int[n];
//            for (int i = 0 ;i<n ;i++){
//                item[i] = scanner.nextInt();
//            }
//            System.out.println(Arrays.toString(item));
//        }


        //输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。
//        范围均在-30到30之间(闭区间)。
        while (scanner.hasNextInt()) {
            int y1 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int y3 = scanner.nextInt();
            int y4 = scanner.nextInt();

            System.out.println(y1+" "+y2+" "+" "+y3+" "+y4);
        }
    }
}