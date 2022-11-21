package top.damoncai.juc2022.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Interrupted
 */
public class Demo_06_Interrupted {

    static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello - t1: " + i++);
            }
            System.out.println("t1结束");
        });

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // sleep线程会进入time waiting状态
                    // WAITING或者TIMED_WAITING状态的线程，从而抛出异常自行处理
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("hello - t2: " + i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("基于打断形式结束当前线程");
                    return;
                }
            }
            System.out.println("t1结束");
        });

        t.start();
        t2.start();

        TimeUnit.SECONDS.sleep(6);
        t.interrupt();
        t2.interrupt();
    }
}
