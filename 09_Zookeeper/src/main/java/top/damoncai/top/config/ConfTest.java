package top.damoncai.top.config;

import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhishun.cai
 * @date 2021/3/2 20:30
 */

public class ConfTest {

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
    public void test() {
        WatchCallBack watchCallBack = new WatchCallBack(zk);
        zk.exists("/AppConf",watchCallBack,watchCallBack,"ABC");

        while (true) {
            System.out.println(WatchCallBack.myConf.getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
