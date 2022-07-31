package top.damoncai.juc2022.chapter02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock
 */
public class Demo_04_Lock {

    private static int count;

    private static ReentrantLock lock = new ReentrantLock();

    public static void increment()  {
        lock.lock();
        try {
            count++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });
        Thread t2 = new Thread(() -> {
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
