package center.helloworld.netty.chapter_02_eventloop;

import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author zhishun.cai
 * @create 2023/5/11
 * @note 执行普通任务
 */
public class Demo_02_Common_Job {


    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup nioWorkers = new NioEventLoopGroup(2);

        Thread.sleep(2000);
        nioWorkers.execute(()->{
            System.out.println("normal task...");
        });
    }
}
