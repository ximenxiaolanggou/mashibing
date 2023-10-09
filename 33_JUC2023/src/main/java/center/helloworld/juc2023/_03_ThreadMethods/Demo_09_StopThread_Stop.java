package center.helloworld.juc2023._03_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note stop停止线程
 */
public class Demo_09_StopThread_Stop {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
            () -> {
                while (true) ;
            }
        );

        t1.start();
        Thread.sleep(1000);
        // 不推荐使用
        t1.stop();
    }
}
