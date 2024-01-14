package center.helloworld.juc2023._07_ReentrantReadWriterLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读读锁不互斥
 */
public class Demon_01_ReadReadLock {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        new Thread(() -> {
            try {
                readLock.lock();
                System.out.println("T1 进入读锁~~");
                Thread.sleep(2000);
            }catch (Exception e){

            }finally {
                readLock.unlock();
            }
            System.out.println("T1 即将结束~~");
        }, "T1").start();

        new Thread(() -> {
            try {
                readLock.lock();
                System.out.println("T2 进入读锁~~");
                Thread.sleep(2000);
            }catch (Exception e){

            }finally {
                readLock.unlock();
            }
            System.out.println("T2 即将结束~~");
        }, "T1").start();
    }
}
