package center.helloworld.juc2023._04_Thread_Three_Charact;

/**
 * @author zhishun.cai
 * @create 2023/10/9
 * @note 可见性 - Synchronized
 */
public class Demo_06_Visibility_Synchronized {
    public static boolean flag = true;

    /**
     * 如果将synchronized放置在while外面，这里是无法停止子线程的，
     * 因为是获取锁资源之后，才会将涉及到的变量从CPU缓存中移除，从主存中获取。
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (Demo_06_Visibility_Synchronized.class) {
                while (flag) {

                }
                System.out.println("子线程结束");
            }
        }).start();

        Thread.sleep(100);

        flag = false;
        System.out.println("main线程结束");
    }
}
