package top.damoncai.juc2022.chapter03;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 * 读写锁
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/8/3 11:00
 */
public class Demo_04_ReentryReadWriteLock {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            readLock.lock();
            try {
                System.out.println("子线程");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }).start();

        Thread.sleep(1000);
        readLock.lock();
        try {
            System.out.println("主线程");
        }finally {
            readLock.unlock();
        }
    }
}
