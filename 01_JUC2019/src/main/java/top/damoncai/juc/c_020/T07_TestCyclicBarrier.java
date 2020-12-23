package top.damoncai.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author zhishun.cai
 * @date 2020/12/16 20:13
 */

public class T07_TestCyclicBarrier {
    static CyclicBarrier barrier = new CyclicBarrier(10,() -> {
        System.out.println("all do something~~~");
    });

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ; i < 10 ; i++) {
            TimeUnit.SECONDS.sleep(1);
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread() + "before");
                    barrier.await();
                    System.out.println(Thread.currentThread() + "after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
