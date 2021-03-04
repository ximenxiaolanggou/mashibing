package top.damoncai.top.lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.damoncai.top.config.ZKUtils;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhishun.cai
 * @date 2021/3/3 13:56
 */

public class TestLock {

    ZooKeeper zk;
    CountDownLatch latch = new CountDownLatch(1);
    @Before
    public void before() throws Exception {
        zk = ZKUtils.INSTANCE();
    }

    @After
    public void after() {
        ZKUtils.close();
    }

    @Test
    public void test() throws Exception {

        for (int i = 0; i < 10; i++) {
            zk = ZKUtils.INSTANCE();
            WatchCallBack watchCallBack = new WatchCallBack(zk,"Thread - " + i);
            new Thread(() -> {
                //上锁
                watchCallBack.lock();
                //业务
                try {
                    System.out.println("working ~~~");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //释放锁
                watchCallBack.unLock();
            },"Thread - " + i).start();
        }

        while (true) {

        }
    }
}
