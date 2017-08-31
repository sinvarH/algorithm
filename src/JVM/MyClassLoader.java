package JVM;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 7/19/2017.
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = loadClassData(name);
        return defineClass(name,bytes,0,bytes.length);

    }
    private byte[] loadClassData(String className){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(className.replace(".","/")+".class");
        ByteOutputStream byteOutputStream = new ByteOutputStream();
        int len = 0;
        try {
            while ((len = inputStream.read())!=-1){
               byteOutputStream.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteOutputStream.toByteArray();
    }
}
