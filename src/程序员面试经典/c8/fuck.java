package 程序员面试经典.c8;

/**
 * Created by Administrator on 2017/3/21.
 */
public interface fuck<K,V> {
    default V putIfAbsent(K key, V value) {

        return value;
    }
}
