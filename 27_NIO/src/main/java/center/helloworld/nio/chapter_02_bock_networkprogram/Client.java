package center.helloworld.nio.chapter_02_bock_networkprogram;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author zhishun.cai
 * @create 2023/5/10
 * @note k客户端
 */
public class Client {

    @Test
    public void client() throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put("Hello,world".getBytes());

        // 1. 创建客户端
        SocketChannel client = SocketChannel.open();

        // 2. 连接
        client.connect(new InetSocketAddress(8080));

        buffer.flip();
        client.write(buffer);
        System.in.read();
    }
}
