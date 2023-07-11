package center.helloworld.netty.chapter_08_heart;

import center.helloworld.netty.chapter_07_Customer_Protocol.Client;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.junit.Test;

import java.util.Date;

/**
 * @author zhishun.cai
 * @create 2023/5/11
 * @note Netty 客户端
 */
public class NettyClient {

    static final Logger log = LoggerFactory.getLogger(NettyClient.class);

    public static void main(String[] args) throws InterruptedException {
        new Bootstrap()
                .group(new NioEventLoopGroup()) // 1
                .channel(NioSocketChannel.class) // 2
                .handler(new ChannelInitializer<Channel>() { // 3
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                System.out.println("断开连接~~");
                            }

                        });
                    }
                })
                .connect("127.0.0.1", 8080) // 4
                .sync() // 5
                .channel() // 6
                .writeAndFlush(new Date() + ": hello world!"); // 7
    }

}
