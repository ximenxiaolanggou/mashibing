package center.helloworld.juc2023._04_Thread_Three_Charact;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhishun.cai
 * @create 2023/10/9
 * @note Lock 原子性操作
 */
public class Demo_04_Atomic_Lock {

    static int count = 0;

    static Lock lock = new ReentrantLock();

    public static void increment(){
        try {
            lock.lock();
            Thread.sleep(10);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
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
