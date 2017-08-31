package 程序员面试经典;

/**
 * Created by Administrator on 2017/3/10.
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 这里规定大小写为不同字符，且考虑字符串重点空格。
 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 */
public class third {
    public static boolean checkSam(String stringA, String stringB) {
        // write code here
        if (stringA.length() != stringB.length()) {
            return  false;
        }else if (stringA.equals(stringB)){
          return true;
        }else {
            int[] a = new int[256];
            int[] b = new int[256];
            for (int i = 0; i < stringA.length(); i++) {
                a[(int)(stringA.charAt(i))] += 1;
                b[(int)(stringB.charAt(i))] += 1;
            }
            for (int j = 0; j<a.length; j++){
                if (a[j]!=b[j]){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        checkSam("This is nowcoder","is This nowcoder");
    }
}
