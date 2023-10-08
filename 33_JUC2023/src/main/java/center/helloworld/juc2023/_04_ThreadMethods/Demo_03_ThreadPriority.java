package center.helloworld.juc2023._04_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 线程优先级
 */
public class Demo_03_ThreadPriority {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("T1线程"));

        Thread t2 = new Thread(() -> System.out.println("T2线程"));

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }
}
