package top.damoncai.juc2022.chapter09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newCachedThreadPool
 */
public class Demo_04_newCachedThreadPool {

    public static void main(String[] args) throws Exception {

        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 1; i <= 200; i++) {
            threadPool.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
