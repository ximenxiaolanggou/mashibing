package center.helloworld.juc2023._04_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 线程抢占 join
 */
public class Demo_06_Join {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 1){
                try {
                    t1.join(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
