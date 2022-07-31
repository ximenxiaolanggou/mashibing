package top.damoncai.juc2022.chapter02;

import com.sun.org.apache.bcel.internal.generic.LoadClass;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程下可见性 Lock
 */
public class Demo_09_Visible_Lock {

    private static boolean flag = true;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                lock.lock();
                try {
                    //...
                }finally {
                    lock.unlock();
                }
            }
            System.out.println(Thread.currentThread().getName() + "：线程结束");
        }).start();

        Thread.sleep(10);
        flag = false;
        System.out.println("main线程结束~");
    }
}
