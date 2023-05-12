package center.helloworld.netty.chapter_03_channel;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.Scanner;

/**
 * @author zhishun.cai
 * @create 2023/5/12
 * @note CloseFuture相关特性
 */
public class Demo_02_Channel_CloseFuture {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });

        ChannelFuture channelFuture = bootstrap
                .connect("127.0.0.1", 8080);

        channelFuture.addListener((ChannelFutureListener) future -> {
            Channel channel = future.channel();
            System.out.println(channel);
            String line = scanner.nextLine();
            // 输入q代表关闭客户端
            if("q".equals(line)) {
                channel.close();
            }else {
                channel.writeAndFlush(line);
            }
        });

        // 获取channel
        Channel channel = channelFuture.channel();

        // 获取 CloseFuture 对象， 1) 同步处理关闭， 2) 异步处理关闭
        ChannelFuture closefuture = channel.closeFuture();
        closefuture.addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                System.out.println("客户端断开连接做一些事情~~~");
            }
        });
    }
}
