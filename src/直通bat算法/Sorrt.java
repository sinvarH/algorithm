package 直通bat算法;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/24.
 *
 */
public class Sorrt {
    public static void main(String[] args) {
        int [] fuck = {1,2,3};
        int [] a = {1,3,5,4,3,9,7,8};
        int [] b ={30,54,35,48,36,27,12,44,44,8,14,26,17,28};
//        bubbleSort(a,8);
//        System.out.println(Arrays.toString(insertSort(a,8)));

//        mergeSort(a,8);
//        int [] c = {1,3,5,7,8};
//        int [] d = {2,4,6,8};
//        sort(a,0,a.length-1);

        int [] heap= {1,8,5,10,2,6,2};
//        System.out.println(Arrays.toString(heapSort(heap,heap.length)));
        System.out.println(Arrays.toString(heapSort(b,b.length)));
        int[] more = {1,2,3,6,5,4};
        System.out.println(morethanhalfnums(more,more.length));
//        System.out.println(Arrays.toString(shellSort(b,b.length)));
    }

    /**
     * 冒泡排序
     * @param A
     * @param n
     * @return
     */
    public static int[] bubbleSort(int[] A, int n) {
        // write code here

        for (int i = 0;i<n-1;i++){
            for (int j = 0;j<n-i-1;j++){
                if (A[j]>A[j+1]){
                    A[j] = A[j]^A[j+1];
                    A[j+1] = A[j]^A[j+1];
                    A[j] = A[j]^A[j+1];
                }
            }
        }
//        System.out.println(Arrays.toString(A));
        return A;
    }

    /**
     * 选择排序
     * @param A
     * @param n
     * @return
     */
    public static int[] selectionSort(int[] A,int n){
        //比较次数
        for (int i =0;i<n-1;i++){
            int min = i;
            for (int j = i+1; j<n;j++){
                if (A[j]<A[min]){
                    min = j;
                }
            }
            if (min!=i) {
                A[i] = A[i] ^ A[min];
                A[min] = A[i] ^ A[min];
                A[i] = A[i] ^ A[min];
            }
        }
        return A;
    }

    /**
     * 插入排序
     * @param A
     * @param n
     * @return
     */
    public static int[] insertSort(int[] A,int n){
        //外层循环是已经排好序的个数
        for(int i = 1 ; i<n ;i++){
            for (int j = i ;j>0;j--){
                if (A[j]<A[j-1]){
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
            }
        }
        return A;
    }


    /**
     * 插入排序是希尔排序的一种特殊情况，当希尔排序的初始步长为1时，即为插入排序。
     * @param A
     * @param n
     * @return
     */
    public static int[]  shellSort(int [] A,int n ){
        int feet = n/2 ;
        for (int i = feet;i>0;i--){
            shellSort(A,i,n);
        }
        return A;

    }
    public static int[]  shellSort(int [] A,int feet,int n ){
        for (int i = feet;i<n;i++){
            for (int j = i ;j<n;j+=feet){
                if (A[j]<A[j-feet]){
                    int temp = A[j];
                    A[j] = A[j-feet];
                    A[j-feet] = temp;
                }
            }
        }
        return A;
    }

    /**
     * 归并排序
     * @param A
     * @param n
     * @return
     */
    public static int[] mergeSort(int[] A, int n) {
        // write code here
        int[] fuck = new int[n];
        if (n>1){
            int[] former = new int[n/2];
            System.arraycopy(A,0,former,0,n/2);
            mergeSort(former,n/2);

            int[] latter = new int[n-(n/2)];
            System.arraycopy(A,n/2,latter,0,n-(n/2));
            mergeSort(latter,n-(n/2));

            int [] temp = merge(former,latter);
            System.arraycopy(temp,0,fuck,0,temp.length);
        }
        return fuck;
    }

    public static int[] merge(int[] A, int[] B){
        //有序的A数组和B数组合并
        int[] C = new int[A.length+B.length];
        int currentA = 0;
        int currentB = 0 ;
        int currentC = 0 ;

        while (currentA<A.length&&currentB<B.length){
            if (A[currentA]<B[currentB]){
                C[currentC++] = A[currentA++];
//                效果相同
//                C[currentC] = A[currentA];
//                currentC++;
//                currentA++;
            }else {
                C[currentC++] = B[currentB++];
            }
        }

        //将剩余不等长的添加上去
        while (currentA<A.length){
            C[currentC++] = A[currentA++];
        }

        while (currentB<B.length){
            C[currentC++] = B[currentB++];
        }
        return C;
    }


    /**
     * 快速排序
     * @param A
     * @param n
     * @return
     */
    public static int[] quickSort(int[] A,int n){
        quickSort(A,0,n-1);
        return A;
    }

    public static int[] quickSort(int A[],int start,int end){
       if (start<end){
           int mid = sort(A,start,end);
           quickSort(A,start,mid-1);
           quickSort(A,mid+1,end);
       }
        return A;
    }
    public static int morethanhalfnums(int[] nums,int length){
        if(nums==null||length==0)
            return -1;
        int mid = length>>1;
        if (mid ==0)
            return nums[0];
        int start = 0 ,end = length-1;
        int index = sort(nums,start,end);
        while (index!=mid){
            if (index>mid){
                index = sort(nums,start,index);
            }else {
                index = sort(nums,mid,end);
            }
        }
        return nums[mid];
    }
    /**
     * 在数组内选定一个数，比他小的放到他左边，比他大的放到右边
     */
    public static int sort(int A[] ,int start,int end ){
        int key = A[start];
        int i = start;
        int j = end;
        if (start<end){
            while (i<j){
//                while (i<j&&A[j]<=)
                //找到比key小的
//                放到前面
                while (i<j&&A[j]>=key){
                    j--;
                }
                A[i] = A[j];
                //找到比key大的
                while (i<j&&A[i]<=key){
                    i++;
                }
                A[j] = A[i];
            }
            A[i] = key;
        }
        return i;
    }


//    public static int[] heapSort(int[] A,int n ){
//        // //1,建立大根堆
//        A=buildMaxHap(A);
//    }
//
//    static void heapAdjust(int[] A ,int index,int length){
//        int childLeft;
//        int temp = A[index];
//
//        for (;index*2+1)
//    }
//
//    static int[] buildMaxHap (int[] A){
//        for(int i = A.length/2;i>0;i--){
//            adjustHeap(A,i,A.length);
//        }
//    }
//    //堆的调整:将元素A[k]自下往上逐步调整树形结构
//    private static void adjustHeap(int[] A, int k, int len) {
//        int tem=A[k];
//        for(int i=2*k+1;i<len;i=2*i+1){
//            if(i!=len-1 && A[i]<A[i+1]){
//                i++;//右>左,取右
//            }
//            if(tem>A[i]){
//                break;//根>右,结束
//            }else{
//                //否则,改变根植,并继续向下调整
//                A[k]=A[i];
//                k=i;//【关键】修改k值，以便继续向下调整
//            }
//        }
//        A[k]=tem; //被调整的结点的值放入最终位置
//    }

    /**
     * 计数排序
     * @param A
     * @param n
     * @return
     */
    public int[] countingSort(int[] A, int n) {
        // write code here
        int min = A[0];
        int max = A[0];
        for (int i:A){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }

        int bucketLength =  max-min+1;
        int [] bucket = new int[bucketLength];

        for (int i: A){
            bucket[i-min]++;
        }

        int index = 0 ;
        for(int i = 0 ;i<bucketLength;i++){
            for (int j = 0; j<bucket[i];j++){
                A[index++] = i+min;
            }
        }
        return A;
    }


    //堆排序非递归实现
    public static void adjustHeap (int [] A,int k,int len){
        int temp = A[k];
        for (int i = 2*k+1;i<len;i = i*2+1){
            if (i+1<len&&A[i]<A[i+1]){
                i++;
            }
            if (temp>A[i]){
                break;
            }else {
                A[k] = A[i];
                k = i;
            }
        }
        A[k] = temp;
    }

    //堆排序的递归实现
    public static void adjustHeap2(int[] A,int k,int len){
        int left = 2*k+1;
        int right = 2*k+2;
        int maxId = k;
        if(k<=len/2){
            if (left<len&&A[left]>A[maxId]){
                maxId = left;
            }
            if (right<len&&A[right]>A[maxId]){
                maxId = right;
            }
            if (maxId!=k){
                int temp = A[maxId];
                A[maxId] = A[k];
                A[k] = temp;
                adjustHeap(A,maxId,len);
            }
        }
    }

    public static int[] heapSort(int[] A, int n) {
        // write code here
        //建立大根堆
        for (int i = n/2 ;i>=0;i--){
            adjustHeap2(A,i,n);
        }
//        //调整
        for (int i = n-1;i>0;i--){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            adjustHeap2(A,0,i);
        }
        return A;
    }

    public static int[] redixSort(int [] A,int n){
        int [][] bucket = new int[10][n];
        //数组orderp[i]用来表示该位是i的数的个数
        int [] order = new int[10];
        //导入导出四次
        for (int i = 1;i<=1000;i=i*10){
            int h = 0;
            for (int j = 0;j<A.length;j++){
                int lsd = (A[j]/i)%10;
                bucket[lsd][order[lsd]] = A[j];
                order[lsd]++;
            }
            for(int k = 0;k<10;k++){
                if (order[k]!=0){
                    for (int q =0;q<order[k];q++){
                        A[h] = bucket[k][q];
                        h++;
                    }
                }
                order[k] = 0;
            }
        }
        return A;
    }
}
