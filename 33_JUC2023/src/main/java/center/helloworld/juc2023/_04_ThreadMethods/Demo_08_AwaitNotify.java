package center.helloworld.juc2023._04_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 等待通知
 */
public class Demo_08_AwaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            sync();
        }, "T1");

        Thread t2 = new Thread(() -> {
            sync();
        }, "T2");
        t1.start();
        t2.start();

        Thread.sleep(6000);
        synchronized (Demo_08_AwaitNotify.class) {
            // notify方法将等待池中的所有线程放入到锁池中，等线程释放锁后，抢占锁资源
            Demo_08_AwaitNotify.class.notifyAll();
        }
    }

    public static synchronized void sync() {
        try {
            for (int i = 0; i < 10; i++) {
                if(i == 5) {
                    Demo_08_AwaitNotify.class.wait();
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
