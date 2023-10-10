package center.helloworld.juc2023._05_Synchronized_Upgrade;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zhishun.cai
 * @create 2023/10/10
 * @note JVM 默认4s后开启偏向锁，这里测试在未开启偏向锁的情况下，锁升级情况
 */
public class Demo_01_No_Bias {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
