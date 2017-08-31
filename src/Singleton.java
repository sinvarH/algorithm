/**
 * Created by Administrator on 7/5/2017.
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getSingleton (){
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }


    public static void main(String[] args) {
        Integer integer = new Integer(10);
        Integer integer2 = new Integer(11);
        System.out.println(integer.equals(integer2));
        String s1 ="wd";
        String s2 = new String("wd");
        System.out.println(s1.equals(s2));

    }
    public void sout(){
        System.out.println(this);
        String s = "wd";
        String t = "www";
        String r = s+t;
        StringBuilder sb = new StringBuilder("ss");
        sb.append("aaaa");
        System.out.println(r);
    }
}
