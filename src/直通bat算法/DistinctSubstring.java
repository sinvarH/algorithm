package 直通bat算法;

/**
 * Created by Administrator on 2017/4/26.
 */
public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        // write code here
        if(A==null || n==0){
            return 0;
        }
        char[] chas=A.toCharArray();
        int[] map=new int[256];//256个字符：记录每种字符之前出现的位置
        for(int i=0;i<256;i++){
            map[i]=-1;
        }
        int len=0;
        int pre=-1;
        int cur=0;//当前字符为止的最长无重复字符串的长度
        for(int i=0;i<n;i++){
            pre=Math.max(pre, map[chas[i]]);
            cur=i-pre;
            len=Math.max(len, cur);
            map[chas[i]]=i;
        }
        return len;
    }
}