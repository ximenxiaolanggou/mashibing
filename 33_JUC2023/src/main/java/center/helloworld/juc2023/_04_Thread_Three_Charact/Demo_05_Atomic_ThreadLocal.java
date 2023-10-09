package center.helloworld.juc2023._04_Thread_Three_Charact;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhishun.cai
 * @create 2023/10/9
 * @note ThreadLocal 不让多线程去操作临界资源
 */
public class Demo_05_Atomic_ThreadLocal {
    static ThreadLocal t1 = new ThreadLocal();
    static ThreadLocal t2 = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        t1.set("张三");
        t2.set("12");

        new Thread(() -> {
            System.out.println("子线程t1值：" + t1.get());
            System.out.println("子线程t2值：" + t2.get());
        }).start();

        Thread.sleep(100);

        System.out.println("main线程t1值：" + t1.get());
        System.out.println("main线程t2值：" + t2.get());
    }
}
