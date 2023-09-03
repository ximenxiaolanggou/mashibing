package center.hellowrold.so._01_java_base;

/**
 * @author zhishun.cai
 * @create 2023/9/2
 * @note 线程join 方法
 */
public class _10_Thread_Join {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程");
        });
        t.start();
        // 使用join 让子线程先执行，等执行完成后再执行主线程
        t.join();
        System.out.println("main 线程");
    }
}
