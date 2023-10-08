package center.helloworld.juc2023._04_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 共享变量停止线程
 */
public class Demo_10_StopThread_Var {

    // 需要添加volite来保证可见性
    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                () -> {
                    while (flag) {

                    }
                    System.out.println("子线程结束~~");
                }
        );

        t1.start();
        Thread.sleep(100);
        flag = false;
    }
}
