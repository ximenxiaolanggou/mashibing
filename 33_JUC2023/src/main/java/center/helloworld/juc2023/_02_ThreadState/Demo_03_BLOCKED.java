package center.helloworld.juc2023._02_ThreadState;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 阻塞状态
 */
public class Demo_03_BLOCKED {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o) {

            }
        });

        t1.start();

        synchronized (o) {
            Thread.sleep(500);
            System.out.println(t1.getState());
        }
    }
}
