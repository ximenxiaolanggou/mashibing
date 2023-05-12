package center.helloworld.nio.chapter_03_selector_accept_read;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static center.helloworld.nio.utils.ByteBufferUtil.debugRead;

/**
 * @author zhishun.cai
 * @create 2023/5/10
 * @note
 */
public class Server {

    @Test
    public void server() throws IOException {

        List<SocketChannel> channels = new ArrayList<>();

        // 1. 创建服务器
        ServerSocketChannel ssc = ServerSocketChannel.open();

        // 2. 设置为非阻塞模式
        ssc.configureBlocking(false);

        // 3. 创建选择器并注册监听ACCEPT事件
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        // 4.绑定端口
        ssc.bind(new InetSocketAddress(8080));

        while (true) {

            selector.select(); // 阻塞
            // 获取所有事件
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();// 非阻塞
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                if(key.isAcceptable()) { // 连接事件
                    ServerSocketChannel c = (ServerSocketChannel) key.channel();
                    // 必须处理
                    SocketChannel channel = c.accept();
                    channel.configureBlocking(false);
                    channels.add(channel);
                    channel.register(selector, SelectionKey.OP_READ);
                    System.out.println(channel.getRemoteAddress());

                }else if(key.isReadable()) { // 读事件
                    SocketChannel c = (SocketChannel) key.channel();
                    ByteBuffer buf = ByteBuffer.allocate(20);
                    // 当客户端手动关闭时（SocketChannel.close()）会触发服务端的读， 并且为-1
                    int read = c.read(buf);
                    if(read == -1) {
                        key.cancel();
                        c.close();
                    } else {
                        buf.flip();
                        debugRead(buf);
                    }

                }
                // 处理完毕，必须将事件移除
                iter.remove();
            }
        }
    }
}
