package center.helloworld.juc2023._08_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhishun.cai
 * @create 2023/10/19
 * @note newSingleThreadExecutor 构建单例线程数线程池
 */
public class Demo_02_newSingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        threadPool.execute(() -> {
            System.out.println("任务1：" + Thread.currentThread().getName() + " - " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            System.out.println("任务2：" + Thread.currentThread().getName() + " - " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            System.out.println("任务3：" + Thread.currentThread().getName() + " - " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
