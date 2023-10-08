package center.helloworld.juc2023._02_ThreadState;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 终止状态
 */
public class Demo_06_TERMINATED {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
        });

        t1.start();

        Thread.sleep(100);
        System.out.println(t1.getState());
    }
}
