package 程序员面试经典;

/**
 * Created by Administrator on 2017/3/9.
 * 链接：<a href="https://www.nowcoder.com/questionTerminal/9618c2a9e8a14c3e82954ee14168f592">https://www.nowcoder.com/questionTerminal/9618c2a9e8a14c3e82954ee14168f592</a>
 来源：牛客网

 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 测试样例：
 */
public class first {
    public static  boolean checkDifferent(String iniString) {
        // write code here
        int[] a = new int[256];

        for (int i = 0 ;i<iniString.length();i++){
            a[(int)(iniString.charAt(i))]+=1;
        }
        for (int j :
             a) {
            if (j>1){
                return false;
            }
        }
        return true;
    }

    public static  boolean checkDifferent2(String iniString) {
        // write code here


        for (int i = 0 ;i<iniString.length()-1;i++){
            for (int j=i+1;j<iniString.length();j++){
                if (iniString.charAt(i)==iniString.charAt(j)){
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "acbdbesy";
        System.out.println(checkDifferent2(s));
    }
}
