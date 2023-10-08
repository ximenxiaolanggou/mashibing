package center.helloworld.juc2023._02_ThreadState;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 等待状态
 */
public class Demo_04_WAITING {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        Thread.sleep(500);
        System.out.println(t1.getState());
    }
}
