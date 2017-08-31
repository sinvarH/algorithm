package JVM;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 7/15/2017.
 * 对于栈内存溢出，根据《Java 虚拟机规范》中文版：
 * 如果线程请求的栈容量超过栈允许的最大容量的话，Java 虚拟机将抛出一个StackOverflow异常；
 * 如果Java虚拟机栈可以动态扩展，并且扩展的动作已经尝试过，但是无法申请到足够的内存去完成扩展，
 * 或者在新建立线程的时候没有足够的内存去创建对应的虚拟机栈，那么Java虚拟机将抛出一个OutOfMemory 异常
 */
public class OOMTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int count = 0 ;
//        while (true){
//            System.out.println(count++);
//            list.add(UUID.randomUUID().toString().intern());
//        }
    }
    static {
        i =2 ;

    }
    static  int i ;
    static {
        System.out.println(i);
    }

    static {
        if (true){
            System.out.println(Thread.currentThread()+"init");
            try
            {
                TimeUnit.SECONDS.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


    }
    static class DealLoopTest{
    }


}
