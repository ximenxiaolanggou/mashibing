package top.damoncai.juc2022.chapter02;

/**
 * 多线程下可见性 volatile
 */
public class Demo_07_Visible_Volatile {

    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                // Thread.sleep和println()也能保证可见性
                //...
            }
            System.out.println(Thread.currentThread().getName() + "：线程结束");
        }).start();

        Thread.sleep(10);
        flag = false;
        System.out.println("main线程结束~");
    }
}
