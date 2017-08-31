package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 7/26/2017.
 */
public class NIOTest{
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssc  = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ServerSocket ss = ssc.socket();

        InetSocketAddress address = new InetSocketAddress(10000);
        ss.bind(address);

        SelectionKey key = ssc.register(selector,SelectionKey.OP_ACCEPT);

        int num  = selector.select();
        Set selectedKey = selector.selectedKeys();
        Iterator it = selectedKey.iterator();

        while (it.hasNext()){
            SelectionKey key1 = (SelectionKey) it.next();
            if ((key1.readyOps()&SelectionKey.OP_ACCEPT)==SelectionKey.OP_ACCEPT){
            }
        }
    }
}
