package top.damoncai.juc2022.chapter03;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 * 写锁源码
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/8/3 11:00
 */
public class Demo_05_ReentryReadWriteLock_Write {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public static void main(String[] args) throws InterruptedException {
        writeLock.lock();
    }
}
