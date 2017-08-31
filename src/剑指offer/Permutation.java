package 剑指offer;

import java.util.Arrays;

/**
 * Created by Administrator on 6/13/2017.
 */
public class Permutation {
    static void permutation(char[] str,int begin){
        if (begin == str.length-1){
            System.out.println(Arrays.toString(str));
            return;
        }
        for (int i = begin ;i<str.length;i++){

            char temp = str[i];
            str[i] = str[begin];
            str[begin] = temp;

            permutation(str,begin+1);

            temp = str[i];
            str[i] = str[begin];
            str[begin] = temp;
        }
    }

    public static void main(String[] args) {
        String test = "1234567";
        char[] t = test.toCharArray();
        String[] n = {"abc","efg","hij"};
        getAll(n,0);
        permutation(t,0);

    }

    static void getAll(String[] strs,int begin){
        if (begin==strs.length-1){
            System.out.println(Arrays.toString(strs));
            return;
        }
        for (int i = begin; i<strs.length;i++){
            String temp = strs[begin];
            strs[i] = strs[begin];
            strs[begin] = temp;

            getAll(strs,begin+1);

            temp = strs[begin];
            strs[i] = strs[begin];
            strs[begin] = temp;

        }
    }
}
