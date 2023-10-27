package center.helloworld.juc2023._08_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhishun.cai
 * @create 2023/10/19
 * @note 构建固定线程数线程池
 */
public class Demo_01_newFixedThreadPool {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.submit(() -> {
            System.out.println("任务1：" + Thread.currentThread().getName() + " - " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.submit(() -> {
            System.out.println("任务2：" + Thread.currentThread().getName() + " - " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.submit(() -> {
            System.out.println("任务3：" + Thread.currentThread().getName() + " - " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
