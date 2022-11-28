package top.damoncai.juc2022.chapter09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool
 */
public class Demo_05_newScheduledThreadPool {

    public static void main(String[] args) throws Exception {

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);

        // 正常执行
        threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " : 正常执行"));

        // 延迟执行，执行当前任务延迟5s后执行
        threadPool.schedule(() -> System.out.println(Thread.currentThread().getName() + " : 延迟执行"),5, TimeUnit.SECONDS);

        // 周期执行，当前任务第一次延迟5s执行，然后没3s执行一次
        // 这个方法在计算下次执行时间时，是从任务刚刚开始时就计算
        threadPool.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName() + " : scheduleAtFixedRate"),2,1,TimeUnit.SECONDS);

        // 周期执行，当前任务第一次延迟5s执行，然后没3s执行一次
        // 这个方法在计算下次执行时间时，会等待任务结束后，再计算时间
        threadPool.scheduleWithFixedDelay(() -> System.out.println(Thread.currentThread().getName() + " : scheduleAtFixedRate"),2,1,TimeUnit.SECONDS);

    }
}
