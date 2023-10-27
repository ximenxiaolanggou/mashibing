package center.helloworld.juc2023._08_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhishun.cai
 * @create 2023/10/19
 * @note 缓存线程池
 */
public class Demo_03_newCachedThreadPool {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 1; i <= 200; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " - " + finalI);
            });

        }
    }
}
