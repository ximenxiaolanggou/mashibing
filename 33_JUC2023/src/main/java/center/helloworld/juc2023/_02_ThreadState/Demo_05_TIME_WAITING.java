package center.helloworld.juc2023._02_ThreadState;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 时间等待状态
 */
public class Demo_05_TIME_WAITING {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();

        Thread.sleep(100);
        System.out.println(t1.getState());
    }
}
