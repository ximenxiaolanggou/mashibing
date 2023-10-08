package center.helloworld.juc2023._02_ThreadState;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 运行状态（就绪状态和运行状态）
 */
public class Demo_02_RUNNABLE {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true);
        });

        t1.start();
        Thread.sleep(100);
        System.out.println(t1.getState());
    }
}
