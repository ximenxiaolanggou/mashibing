package center.helloworld.netty.chapter_01_helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.junit.Test;

/**
 * @author zhishun.cai
 * @create 2023/5/11
 * @note Netty 服务端
 */
public class NettyServer {

    public static void main(String[] args) {
        new ServerBootstrap()
                .group(new NioEventLoopGroup()) // 1
                .channel(NioServerSocketChannel.class) // 2
                .childHandler(new ChannelInitializer<NioSocketChannel>() { // 3
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder()); // 5
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() { // 6
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                .bind(8080); // 4
    }
}
