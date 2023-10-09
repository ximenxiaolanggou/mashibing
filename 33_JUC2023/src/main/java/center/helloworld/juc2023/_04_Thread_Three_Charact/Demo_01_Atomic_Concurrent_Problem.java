package center.helloworld.juc2023._04_Thread_Three_Charact;

/**
 * @author zhishun.cai
 * @create 2023/10/9
 * @note 非原子性并发问题
 */
public class Demo_01_Atomic_Concurrent_Problem {

    static int count = 0;

    public static void increment(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        Thread t2 =new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
