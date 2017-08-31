import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/19.
 * 牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)，牛牛现在想把新捕捉的鱼放入鱼缸。鱼缸内存在着大鱼吃小鱼的定律。经过观察，牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，鱼A会吃掉鱼B。考虑到这个，牛牛要放入的鱼就需要保证：
 1、放进去的鱼是安全的，不会被其他鱼吃掉
 2、这条鱼放进去也不能吃掉其他鱼
 鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。现在知道新放入鱼的大小范围[minSize,maxSize](考虑鱼的大小都是整数表示),牛牛想知道有多少种大小的鱼可以放入这个鱼缸。
 (不用考虑是否放进去的鱼会互相吃掉的问题)
 */
public class SoMuchFish {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int minSize = sc.nextInt();
        int maxSize = sc.nextInt();
        int n = sc.nextInt();
        int [] fishSize = new int[n];
        for (int i = 0;i<n;i++)
            fishSize[i] = sc.nextInt();
        //找出最小size和最大size
        int minOfFish = fishSize[0]/2;
        int maxOfFish = fishSize[0]*10;

        int minOfFish2 = fishSize[0]*2;
        for (int i=0 ;i<n;i++){
            if (fishSize[i]/2<minOfFish){
                minOfFish = fishSize[i]/2;
            }
            if (fishSize[i]*2<minOfFish2){
                minOfFish = fishSize[i]*2;
            }
            if (fishSize[i]*2>maxOfFish){
                maxOfFish = fishSize[i]*2;
            }
        }

        int totalSort=0;
        if (minSize>=minOfFish&&minOfFish2>minSize){
            totalSort += minOfFish2 - minSize-1;
        }else if (minSize>=minOfFish2){
            totalSort += minOfFish2-minOfFish-1;
        }

        if (maxSize>maxOfFish){
            totalSort += maxSize -maxOfFish;
        }

        System.out.println(totalSort);
    }
}
