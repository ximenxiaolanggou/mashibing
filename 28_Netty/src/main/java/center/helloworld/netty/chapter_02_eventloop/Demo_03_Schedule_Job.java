package center.helloworld.netty.chapter_02_eventloop;

import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.TimeUnit;

/**
 * @author zhishun.cai
 * @create 2023/5/11
 * @note  执行定时任务
 */
public class Demo_03_Schedule_Job {


    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup nioWorkers = new NioEventLoopGroup(2);

        nioWorkers.scheduleAtFixedRate(() -> {
            System.out.println("normal task...");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
