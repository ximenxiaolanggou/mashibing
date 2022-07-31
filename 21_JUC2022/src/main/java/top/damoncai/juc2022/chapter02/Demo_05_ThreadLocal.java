package top.damoncai.juc2022.chapter02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock
 */
public class Demo_05_ThreadLocal {

    static ThreadLocal t1 = new ThreadLocal();
    static ThreadLocal t2 = new ThreadLocal();

    public static void main(String[] args) {
        t1.set("A");
        t2.set("B");

        new Thread(() -> {
            Object t1V = t1.get();
            Object t2V = t1.get();
            System.out.println("t：" + t1V);
            System.out.println("t：" + t2V);
        }).start();

        Object t1V = t1.get();
        Object t2V = t1.get();
        System.out.println("main：" + t1V);
        System.out.println("main：" + t2V);
    }
}
