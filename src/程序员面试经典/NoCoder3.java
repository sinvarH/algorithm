package 程序员面试经典;

import java.util.Scanner;

/**
 * Created by Administrator on 6/16/2017.
 */
public class NoCoder3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //编号加起来最大值
        int max = (n-1)*n/2;
        int total = 0 ;

    }

//    int findKSum (int nums[],int k,int target){
//        if (k==2){
//            return twoSum()
//        }
//    }

    /**
     * nums已经排好顺序
     * @param nums
     * @return
     */
    int twoSum(int nums[],int start ,int target){
        int total = 0 ;
        int head = start ;
        int tail = nums.length-1;
        if (head==tail&&nums[head]==target){
            return 1;
        }
        while (head<tail){
            int num = nums[head]+nums[tail];
            if (num==target){
                total++;
                head++;
                tail--;
            }else if (num<target){
                head++;
            }else {
                head--;
            }
        }
        return total;
    }
}
