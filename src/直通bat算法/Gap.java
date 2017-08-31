package 直通bat算法;

/**
 * Created by Administrator on 2017/4/12.
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。

 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 */

public class Gap {
    public int maxGap(int[] A, int n) {
        // write code here
        //找到最小值和最大值
        int max = A[0];
        int min = A[0];
        for (int i = 1 ;i<n;i++){
            if (A[i]>max)
                max = A[i];
            if (A[i]<min){
                min = A[i];
            }
        }

        if (min==max)
            return 0;
        //桶
        boolean [] hasNum = new boolean[n+1];
        int[] maxs = new int[n+1];
        int[] mins = new int[n+1];
        int bid = 0;
        for(int i = 0;i<n;i++){
            bid = bucketNum(A[i],n,min,max);
            mins[bid] = hasNum[bid]? Math.min(mins[bid],A[i]) : A[i];
            maxs[bid] = hasNum[bid]? Math.max(maxs[bid],A[i]) : A[i];
            hasNum[bid] = true;
        }

        //找到第一个不空的桶
        int lastMax = 0;
        ;
//        while (i<=n){
//            if (hasNum[i++]){
//                lastMax = maxs[i-1];
//                break;
//            }
//        }
        int i = 0;
        for ( i = 0 ;i<=n;i++){
            if (hasNum[i]){
                lastMax = maxs[i];
                break;
            }
        }
        int res = 0;
        for (;i<=n;i++){
            if (hasNum[i]){
                res = Math.max(res,mins[i] -lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    //找到应该在第几号桶
    // 使用long类型是为了防止相乘时溢出
    public int bucketNum(long num,long len,long min,long max){
        return (int) ((num-min)*len/(max-min));
    }
}