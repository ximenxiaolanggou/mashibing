package center.hellowrold.so._02_java_juc;

/**
 * @author zhishun.cai
 * @create 2023/9/14
 * @note
 */
public class _01_Thread_Interrupt {

    public static void main(String[] args) {


        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().isInterrupted());

        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.interrupted()); // 如果状态为true,则返回true并且将值改为false
        System.out.println(Thread.currentThread().isInterrupted());
    }
}
