package top.damoncai.juc2022.chapter03;

import org.openjdk.jol.info.ClassLayout;

/**
 * 锁升级
 */
public class Demo_02_synchronized_Level_Up {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        new Thread(() -> {

            synchronized (o){
                //t1  - 偏向锁
                System.out.println("t1:" + ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
        //main - 偏向锁 - 轻量级锁CAS - 重量级锁
        synchronized (o){
            System.out.println("main:" + ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
