package top.damoncai.juc2022.chapter03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * lock源码入口
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/8/3 11:00
 */
public class Demo_03_Lock {

    public static void main(String[] args) throws InterruptedException {
        // 默认是非公平锁，通过传递参数 true|false决定是公平锁还是非公平锁
        ReentrantLock lock = new ReentrantLock(false);
        lock.lock();
        lock.tryLock();
        lock.tryLock(1000, TimeUnit.SECONDS);
        lock.lockInterruptibly();
        lock.unlock();
    }
}
