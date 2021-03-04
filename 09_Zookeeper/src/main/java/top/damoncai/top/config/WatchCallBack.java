package top.damoncai.top.config;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhishun.cai
 * @date 2021/3/2 20:28
 */

public class WatchCallBack implements Watcher, AsyncCallback.StatCallback, AsyncCallback.DataCallback {

    public static MyConf myConf = new MyConf();

    private ZooKeeper zk;

    public WatchCallBack(ZooKeeper zk) {
        this.zk = zk;
    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.EventType type = watchedEvent.getType();
        switch (type) {
            case None:
                break;
            case NodeCreated:
                System.out.println("NodeCreated ~~");
                zk.getData("/AppConf",this,this,"ABC");
                break;
            case NodeDeleted:
                break;
            case NodeDataChanged:
                System.out.println("NodeDataChanged ~~");
                zk.getData("/AppConf",this,this,"ABC");
                break;
            case NodeChildrenChanged:
                break;
        }
    }

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {
        if(stat != null) zk.getData("/AppConf",this,this,"ABC");
    }

    @Override
    public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
        myConf.setName(new String(bytes));
    }
}
