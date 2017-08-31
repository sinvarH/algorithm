package 程序员面试经典;

/**
 * Created by Administrator on 2017/3/13.
 * 链接：https://www.nowcoder.com/questionTerminal/bc12808a2b0f445c96a64406d5513e96
 来源：牛客网

 以s1=ABCD为例，我们先分析s1进行循环移位之后的结果：
 ABCD->BCDA->CDAB->DABC->ABCD  .......
 假设我们把前面移走的数据进行保留：
 ABCD->ABCDA->ABCDAB->ABCDABC->ABCDABCD.....
 因此看出，对s1做循环移位，所得字符串都将是字符串s1s1的子字符串。如果s2可以由s1循环移位得到，则一定可以在s1s1上。
 */
public class eigth {

    public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
	    /* check that s1 and s2 are equal length and not empty */
        if (len == s2.length() && len > 0) {
	    	/* concatenate s1 and s1 within new buffer */
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public boolean checkReverseEqual(String s1, String s2) {
        // write code here

        if(s1.length()==s2.length()&&s1.length()>0){
            String s1s1 = s1+s1;
            return s1s1.contains(s2);
        }else
            return false;
    }



    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
