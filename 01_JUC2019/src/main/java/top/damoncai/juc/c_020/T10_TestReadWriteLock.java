package top.damoncai.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhishun.cai
 * @date 2020/12/17 12:26
 */

public class T10_TestReadWriteLock {
    static Integer count = 0;

    static ReentrantLock lock = new ReentrantLock();
    static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    static Lock readLock = rwLock.readLock();
    static Lock writeLock = rwLock.writeLock();

    public static void read(){
        System.out.println("read: " + count);
    }
    public static void write(){
        count++;
        System.out.println("write: " + count);
    }

    public static void main(String[] args) {

        for (int i = 0 ; i < 10 ; i++) {

            new Thread(() -> {
                try {
//                    lock.lock();
                    readLock.lock();
                    read();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readLock.unlock();
                }
            }).start();
        }

        for (int i = 0 ; i < 2 ; i++) {

            new Thread(() -> {
                try {
//                    lock.lock();
                    writeLock.lock();
                    write();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    writeLock.unlock();
                }
            }).start();
        }
    }
}
