package top.damoncai.top.lock;

import com.sun.xml.internal.ws.server.ServerRtException;
import lombok.SneakyThrows;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhishun.cai
 * @date 2021/3/3 13:59
 */

public class WatchCallBack implements Watcher, AsyncCallback.StringCallback, AsyncCallback.StatCallback, AsyncCallback.Children2Callback {

    private ZooKeeper zk;

    private String pathName;

    private String threadName;

    private CountDownLatch latch = new CountDownLatch(1);

    public WatchCallBack(ZooKeeper zk,String threadName) {
        super();
        this.zk = zk;
        this.threadName = threadName;
    }

    /**
     * watch
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.EventType type = watchedEvent.getType();
        switch (type) {
            case None:
                break;
            case NodeCreated:
                break;
            case NodeDeleted:
                zk.getChildren("/",false,this ,"Lock");
                break;
            case NodeDataChanged:
                break;
            case NodeChildrenChanged:
                break;
        }
    }

    // 加锁逻辑
    public void lock() {
        try {
            zk.create("/lock",threadName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,this,"Lock");
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 释放锁逻辑
    public void unLock() {
        try {
            zk.delete(pathName,-1);
            System.out.println(threadName + " over work....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    /**
     * String Call Back
     * @param i
     * @param s
     * @param o
     * @param s1
     */
    @SneakyThrows
    @Override
    public void processResult(int i, String s, Object o, String s1) {
       pathName = s1;
        System.out.println(threadName  + "  create node : " +  s1 );
       zk.getChildren("/", false,this,"Lock");
    }

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {

    }

    //child Callback
    @SneakyThrows
    @Override
    public void processResult(int i, String s, Object o, List<String> children, Stat stat) {
        Collections.sort(children);
        int index = children.indexOf(pathName.substring(1));
        if(index == 0) { //第一个
            zk.setData("/",threadName.getBytes(),-1); //设置数据
            latch.countDown();
        }else{//不是第一个，观察上一个节点是否存在
            zk.exists("/" + children.get(index - 1),this,this,"Lock");
        }
    }
}
