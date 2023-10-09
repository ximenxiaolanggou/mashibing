package center.helloworld.juc2023._04_Thread_Three_Charact;

/**
 * @author zhishun.cai
 * @create 2023/10/9
 * @note 可见性 - Synchronized
 */
public class Demo_07_Visibility_Synchronized {
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                synchronized (Demo_07_Visibility_Synchronized.class) {
                }
            }
            System.out.println("子线程结束");
        }).start();

        Thread.sleep(100);

        flag = false;
        System.out.println("main线程结束");
    }
}
