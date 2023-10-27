package center.helloworld.juc2023._08_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhishun.cai
 * @create 2023/10/19
 * @note 定时任务线程池
 */
public class Demo_04_newScheduleThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);

        // 正常执行
//        pool.execute(() -> {
//            System.out.println(Thread.currentThread().getName() + "：1");
//        });

        // 延迟执行，执行当前任务延迟5s后再执行
//        pool.schedule(() -> {
//            System.out.println(Thread.currentThread().getName() + "：2");
//        },5,TimeUnit.SECONDS);

        // 周期执行，当前任务第一次延迟5s执行，然后没3s执行一次
        // 这个方法在计算下次执行时间时，是从任务刚刚开始时就计算。
//        pool.scheduleAtFixedRate(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(System.currentTimeMillis() + "：3");
//        },2,1,TimeUnit.SECONDS);

        // 周期执行，当前任务第一次延迟5s执行，然后没3s执行一次
        // 这个方法在计算下次执行时间时，会等待任务结束后，再计算时间
        pool.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "：3");
        },2,1, TimeUnit.SECONDS);
    }
}
