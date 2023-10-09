package center.helloworld.juc2023._04_Thread_Three_Charact;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhishun.cai
 * @create 2023/10/9
 * @note 可见性 - Lock
 */
public class Demo_08_Visibility_Lock {
    public static boolean flag = true;

    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                try {
                    lock.lock();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
            System.out.println("子线程结束");

        }).start();

        Thread.sleep(100);

        flag = false;
        System.out.println("main线程结束");
    }
}
