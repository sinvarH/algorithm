package 直通bat算法;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/4/26.
 */
public class binarySearch {
    public static int binarySearch(int[] srcArray, int des) {
        int low = 0;
        int high = srcArray.length - 1;

        while ((low <= high) && (low <= srcArray.length - 1)
                && (high <= srcArray.length - 1)) {
            //
            int middle = (high+low)>> 1;
            //或者这样写
//            int middle = low+(high-low)/2;
            if (des == srcArray[middle]) {
                return middle;
            } else if (des < srcArray[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        if (nums==null||nums.length==0)
            return -1;
        int low  = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid] == target)
                return mid;
            if(nums[mid]>nums[high]){
                if (target>=nums[low]&&target<nums[mid]){
                    high = mid-1;
                }else
                    low = mid+1;
            }else {
                if (target>nums[mid]&&target<=nums[high]){
                    low =  mid+1;
                }else
                    high = mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7,7,8,9};
        int[] test2 = {7,8,9,1,2,3,4,5,6};
        int [] test4 = {1,1,2};
//        System.out.println(binarySearch(test,5));
        int[] test3 ={3};
        System.out.println(search(test3,3));
//        System.out.println((1+1)/2);
        binarySearch fuck = new binarySearch();
        System.out.println(Arrays.toString(fuck.searchRange(test4,1)));
    }

    public int[] searchRange(int[] A, int target) {
        if (A.length == 0) {
            return new int[]{-1, -1};
        }

        int start, end, mid;
        int[] bound = new int[2];

        // search for left bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        return bound;

    }


}

