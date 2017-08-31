package 程序员面试经典.c8;



import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/21.
 */
public class CustomHash<K,V> {
    private final int MAX_SIZE = 10 ;
    private LinkedList<Cell<K,V>> [] items;
    HashMap n = new HashMap();


    public CustomHash() {
        items = (LinkedList<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
    }

    public void put(K key, V value){
        int x = hashCodeOfKey(key);
        if (items[x]==null){
            items[x]  = new LinkedList<Cell<K,V>>();
        }

        LinkedList<Cell<K,V>> collided = items[x];

        //查找有相同键值的项目，若找到则替换掉
        for (Cell<K,V> c : collided){
            if (c.equivalent(key)){
                collided.remove(c);
                break;
            }
        }

        Cell<K,V> cell = new Cell<K, V>(key,value);
        collided.add(cell);
    }


    public V get(K key){
        int x = hashCodeOfKey(key);
        if (items[x] == null)
            return null;

        LinkedList<Cell<K,V>> collided = items[x];
        for (Cell<K,V> c : collided){
            if (c.equivalent(key)){
                return c.getValue();
            }
        }

        return null;
    }

    //简陋的散列
    public int hashCodeOfKey(K key){
        return key.toString().length()%items.length;
    }

    public static void main(String[] args) {
        CustomHash<String,String> dick = new CustomHash<>();
        dick.put("1","father");
        dick.put("1","mother");
        System.out.println(dick.get("1"));
    }


}
