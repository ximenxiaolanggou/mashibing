package top.damoncai.juc2022.chapter02;

/**
 * 多线程下可见性问题
 */
public class Demo_06_Visible_Problem {

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                //...
            }
            System.out.println(Thread.currentThread().getName() + "：线程结束");
        }).start();

        Thread.sleep(10);
        flag = false;
        System.out.println("main线程结束~");
    }
}
