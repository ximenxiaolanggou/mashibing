package top.damoncai.juc2022.chapter02;

/**
 * 多线程下可见性 Synchronized
 */
public class Demo_08_Visible_Synchronized {

    private static boolean flag = true;

    private static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                synchronized (o) {

                }
            }
            System.out.println(Thread.currentThread().getName() + "：线程结束");
        }).start();

        Thread.sleep(10);
        flag = false;
        System.out.println("main线程结束~");
    }
}
