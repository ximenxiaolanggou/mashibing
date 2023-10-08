package center.helloworld.juc2023._04_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note yield线程让步
 */
public class Demo_04_ThreadYield {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(i == 50){
                    Thread.yield();
                }
                System.out.println("t1:" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t2:" + i);
            }
        });
        t2.start();
        t1.start();
    }
}
