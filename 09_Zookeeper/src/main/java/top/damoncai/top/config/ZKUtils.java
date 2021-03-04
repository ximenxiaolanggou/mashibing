package top.damoncai.top.config;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhishun.cai
 * @date 2021/3/2 20:31
 */

public class ZKUtils {

    private static ZooKeeper zk;

    private static final String CLUSTER = "192.168.220.201:2181,192.168.220.202:2181,192.168.220.203:2181/testLock";

    private static CountDownLatch latch = new CountDownLatch(1);

    private static DefaultWatch DW = new DefaultWatch(latch);

    public static ZooKeeper INSTANCE() throws Exception {
        zk = new ZooKeeper(CLUSTER,1000,DW);
        latch.await();
        return zk;
    }

    public static void close() {
        if(zk != null) {
            try {
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
