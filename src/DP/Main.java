package DP;

import java.util.PriorityQueue;

/**
 * Created by Administrator on 8/23/2017.
 * //完全背包问题的DP解法
 */
public class Main {
    int N =5,W =5;
    int[][] dp = new int[N][W];

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(7);
        priorityQueue.add(6);
        System.out.println(priorityQueue.poll());
    }
}