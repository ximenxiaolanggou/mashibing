package center.helloworld.nio.chapter_02_bock_networkprogram;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static center.helloworld.nio.utils.ByteBufferUtil.debugRead;

/**
 * @author zhishun.cai
 * @create 2023/5/10
 * @note 阻塞 网络编程 服务端
 */
public class Server {

    @Test
    public void server() throws IOException {
        // 数据
        ByteBuffer buffer = ByteBuffer.allocate(100);
        // 连接集合
        ArrayList<SocketChannel> channels = new ArrayList<>();
        // 1. 创建服务器
        ServerSocketChannel server = ServerSocketChannel.open();
        // 2. 绑定服务器端口
        server.bind(new InetSocketAddress(8080));

        while (true) {
            SocketChannel channel = server.accept();
            channels.add(channel);
            channel.read(buffer);
            buffer.flip();
            debugRead(buffer);
            buffer.clear();
        }
    }
}
