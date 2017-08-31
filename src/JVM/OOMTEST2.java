package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 7/15/2017.
 */
public class OOMTEST2 {
    public static void main(String[] args) {
        List<byte[]> buffer = new ArrayList<>();
        //10M
       buffer.add(new byte[10*1024*1024]);
        int i ;

//        int i=0;
//        while(true){
//            buffer.add(new byte[5*1024*1024]);
//            System.out.println("分配次数："+(++i));
//        }
    }

}
