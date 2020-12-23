package top.damoncai.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhishun.cai
 * @date 2020/12/20 12:34
 */

public class Test {

    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
//        fun1(); //ReentryLock condition
//        fun2();  //locksupport
//        fun3(); // await and notify
        fun4(); //Transfer

    }

    public static void fun4(){
        TransferQueue queue = new LinkedTransferQueue();
        int[] nums =  {1,2,3,4,5};
        char[] chars =  {'A','B','C','D','E'};

        new Thread(() -> {
                for (int num : nums) {
                    try {
                        Object take = queue.take();
                        System.out.println(take);
                        queue.transfer(num);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                    }
                }
            }
        ).start();

        new Thread(() -> {
            for (char ch : chars) {
                    try {
                        queue.transfer(ch);
                        Object take = queue.take();
                        System.out.println(take);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                }
            }
        }).start();
    }

    public static void fun3() {
        final Object object = new Object();
        int[] nums =  {1,2,3,4,5};
        char[] chars =  {'A','B','C','D','E'};
        new Thread(() -> {
            synchronized (object) {
            for (int num : nums) {
                    try {
                        System.out.println(num);
                        object.notify();
                        object.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                    }
                }
                object.notifyAll(); // 结束程序
            }
        }).start();

        new Thread(() -> {
            for (char ch : chars) {
                synchronized (object) {
                    try {
                        System.out.println(ch);
                        object.notify();
                        object.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                    }
                }
            }
        }).start();
    }

    public static void fun2() {

        int[] nums =  {1,2,3,4,5};
        char[] chars =  {'A','B','C','D','E'};
        t1 = new Thread(() -> {
            for (int num : nums) {
                try {
                    System.out.println(num);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                }
            }
        });

        t2 = new Thread(() -> {
            for (char ch : chars) {
                try {
                    LockSupport.park();
                    System.out.println(ch);
                    LockSupport.unpark(t1);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                }
            }
        });
        t1.start();
        t2.start();

    }
    public static void fun1() {
        ReentrantLock lock = new ReentrantLock();
        Condition con1 = lock.newCondition();
        Condition con2 = lock.newCondition();
        new Thread(() -> {
            int[] nums =  {1,2,3,4,5};
            for (int num : nums) {
                try {
                    lock.lock();
                    System.out.println(num);
                    con2.signalAll();
                    con1.await();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            char[] chars =  {'A','B','C','D','E'};
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (char ch : chars) {
                try {
                    lock.lock();
                    System.out.println(ch);
                    con1.signalAll();
                    con2.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
