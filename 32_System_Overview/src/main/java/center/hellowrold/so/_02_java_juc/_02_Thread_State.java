package center.hellowrold.so._02_java_juc;

/**
 * @author zhishun.cai
 * @create 2023/9/14
 * @note 线程状态
 */
public class _02_Thread_State {

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
        });
        System.out.println(t1.getState());

        t1.start();
    }
}
