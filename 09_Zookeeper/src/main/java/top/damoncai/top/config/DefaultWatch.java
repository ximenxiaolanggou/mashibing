package top.damoncai.top.config;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhishun.cai
 * @date 2021/3/2 20:33
 */

public class DefaultWatch implements Watcher {

    ZooKeeper zk;

    CountDownLatch latch;

    public DefaultWatch (CountDownLatch latch) {
        super();
        this.latch = latch;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.KeeperState state = watchedEvent.getState();
        switch (state) {
            case Unknown:
                break;
            case Disconnected:
                System.out.println("Disconnected ~~");
                break;
            case NoSyncConnected:
                break;
            case SyncConnected:
                System.out.println("SyncConnected ~~");
                latch.countDown();
                break;
            case AuthFailed:
                break;
            case ConnectedReadOnly:
                break;
            case SaslAuthenticated:
                break;
            case Expired:
                break;
        }
    }
}
