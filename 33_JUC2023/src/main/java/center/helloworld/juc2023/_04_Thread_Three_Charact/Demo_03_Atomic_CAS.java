package center.helloworld.juc2023._04_Thread_Three_Charact;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhishun.cai
 * @create 2023/10/9
 * @note CAS 原子性操作
 */
public class Demo_03_Atomic_CAS {

    static AtomicInteger count = new AtomicInteger(0);

    public static void increment(){
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        Thread t2 =new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
