package top.damoncai.juc2022.chapter09;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试局部线程池使用完不进行shutdown的后果
 */
public class Demo_03_newFixedThreadPool_NoShutdown {

    public static void main(String[] args) throws Exception {

        ExecutorService threadPool = Executors.newFixedThreadPool(200);

        for (int i = 0; i < 200; i++) {
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }

        System.gc();
        Thread.sleep(5000);
        System.in.read();
    }
}
