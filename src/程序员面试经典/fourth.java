package 程序员面试经典;

/**
 * Created by Administrator on 2017/3/10.
 */
public class fourth {
    public String replaceSpace(String iniString, int length) {
        // write code here
        StringBuffer stringBuffer = new StringBuffer();
        for (int i= 0;i<length;i++){
            if (iniString.charAt(i)==' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(iniString.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}
