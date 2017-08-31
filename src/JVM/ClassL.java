package JVM;

/**
 * Created by Administrator on 7/19/2017.
 */
public class ClassL{
    public static void main(String[] args) throws Exception {
        test();
    }
    private static void test() throws Exception {
//        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("ClassL的类加载器"+ClassL.class.getClassLoader());
//        System.out.println("systme"+appClassLoader);
//        ClassLoader extClassLoader = appClassLoader.getParent();
//        System.out.println("sys父加载器"+extClassLoader);
//        ClassLoader bo =extClassLoader.getParent();
//        System.out.println("ext夫加载器"+bo);
//        Integer i = 100;
//        Long j = 10L;
//
//        System.out.println(i.equals(100));
//        String s = "wdawkdio";
////        System.out.println(s.equals());
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> c = myClassLoader.findClass("java.lang.String");

//        System.out.println("load by"+c.getClassLoader());
//        System.out.println(Person.class.getClassLoader());
//
//        Person p = (Person)c.newInstance();
//        p.say();
//        System.out.println("person的类加载器"+p.getClass().getClassLoader());
//        Student s = (Student) c.newInstance();
//        s.say();

    }
    private String jsid(){
        throw new NullPointerException();
    }
}
