package 直通bat算法;

/**
 * Created by Administrator on 2017/4/4.
 */
public class KMP {
    public static void main(String[] args) {
        chkRotation("ANUAAGRJTZKPKQHJTIWHIHWCHMNCPUBQHKZNFJQDXFEUJBRQSKQMNABKITIQSUKUNYIGCRHYGWINANKPOWUMHADPGRIAMNZYNRDQNVPRZEZFESQNEVBLILJYVKHEXGAAOJCQIIHXFFLNRQEJLZWQYLCOOUJQAHTPPLFVMIAWXJYULMWNZYKEJEIANPPPAHESMYWJUGFPUIKQMWLFZDKTSMOKXOPQVIHGCFPSOREDDKETIBKBLHFKDWQYCDIQEIGDMXLHQFPKZVPXHGCJEROFIBOLYWM",9,"OLYWMANUAAGRJTZKPKQHJTIWHIHWCHMNCPUBQHKZNFJQDXFEUJBRQSKQMNABKITIQSUKUNYIGCRHYGWINANKPOWUMHADPGRIAMNZYNRDQNVPRZEZFESQNEVBLILJYVKHEXGAAOJCQIIHXFFLNRQEJLZWQYLCOOUJQAHTPPLFVMIAWXJYULMWNZYKEJEIANPPPAHESMYWJUGFPUIKQMWLFZDKTSMOKXOPQVIHGCFPSOREDDKETIBKBLHFKDWQYCDIQEIGDMXLHQFPKZVPXHGCJEROFIB",9);
    }

    public static boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
         A = A+A;
        char [] fuckA = A.toCharArray();
        char[] fuckB = B.toCharArray();
        int[] next = new int[fuckB.length];
        System.out.println(kmp(fuckA,fuckB,next));
        return false;
    }

    static boolean kmp (char[] T,char[] find,int [] next){
        makeNext(find,next);
        int matchCount = 0 ;
        for (int i = 0 ;i<T.length;){
            //找到第一个且的字符长度大于查找的字符长度
            if (T[i] == find[0]&&(i-1+find.length<T.length)){
                matchCount = 1;
                for (int j = 1;j<find.length;j++){
                    if (find[j]==T[i+j]){
                        matchCount++;
                    }else {
                        //这里不break的话会影响到下面的matchCount
                        break;
                    }
                }
            }
            if (matchCount==find.length){
                return true;
            }else if (matchCount>0){
                i += matchCount-next[matchCount-1];
            }else if (matchCount==0){
                i++;
            }
            matchCount=0;
        }
        return false;
    }

    public static void makeNext(char[] p ,int[] next){
        //这段可以优化，但是这样写好理解
        int q,k;
        int length = next.length;
        next[0] = 0;
        for (q = 1,k=0;q<length;q++){
            while (k>0&&p[q]!=p[k]){
                k = next[k-1];//这里写成K--也行
            }
            if (p[q] == p[k]){
                k++;
            }
            next[q] = k;
        }
    }


}
