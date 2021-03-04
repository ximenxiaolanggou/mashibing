package top.damoncai.top;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhishun.cai
 * @date 2021/3/2 17:21
 */

public class App {

    private static final String CLUSTER = "192.168.220.201:2181,192.168.220.202:2181,192.168.220.203:2181";

    private static final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(CLUSTER, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Event.KeeperState state = event.getState();

                Event.EventType type = event.getType();

                switch (state) {
                    case Unknown:
                        System.out.println("Unknown");
                        break;
                    case Disconnected:
                        System.out.println("Disconnected");
                        break;
                    case NoSyncConnected:
                        System.out.println("NoSyncConnected");
                        break;
                    case SyncConnected:
                        System.out.println("SyncConnected");
                        latch.countDown();
                        break;
                    case AuthFailed:
                        System.out.println("AuthFailed");
                        break;
                    case ConnectedReadOnly:
                        System.out.println("ConnectedReadOnly");
                        break;
                    case SaslAuthenticated:
                        System.out.println("SaslAuthenticated");
                        break;
                    case Expired:
                        System.out.println("Expired");
                        break;
                }

                switch (type) {
                    case None:
                        System.out.println("None");
                        break;
                    case NodeCreated:
                        System.out.println("NodeCreated");
                        break;
                    case NodeDeleted:
                        System.out.println("NodeDeleted");
                        break;
                    case NodeDataChanged:
                        System.out.println("NodeDataChanged");
                        break;
                    case NodeChildrenChanged:
                        System.out.println("NodeChildrenChanged");
                        break;
                }
            }
        });

        latch.await();
        ZooKeeper.States state = zk.getState();

        switch (state) {
            case CONNECTING:
                System.out.println("ing......");
                break;
            case ASSOCIATING:
                break;
            case CONNECTED:
                System.out.println("ed........");
                break;
            case CONNECTEDREADONLY:
                break;
            case CLOSED:
                break;
            case AUTH_FAILED:
                break;
            case NOT_CONNECTED:
                break;
        }


        String pathName = zk.create("/aaa", "olddata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(pathName);


        final Stat stat=new Stat();
        byte[] node = zk.getData("/ooxx", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("getData watch: "+event.toString());
                try {
                    //true   default Watch  被重新注册   new zk的那个watch
                    zk.getData("/ooxx",this  ,stat);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, stat);

        System.out.println(new String(node));

        //触发回调
        Stat stat1 = zk.setData("/ooxx", "newdata".getBytes(), 0);
        //还会触发吗？
        Stat stat2 = zk.setData("/ooxx", "newdata01".getBytes(), stat1.getVersion());

        System.out.println("-------async start----------");
        zk.getData("/ooxx", false, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                System.out.println("-------async call back----------");
                System.out.println(ctx.toString());
                System.out.println(new String(data));

            }

        },"abc");
        System.out.println("-------async over----------");



        Thread.sleep(Integer.MAX_VALUE);
    }
}
