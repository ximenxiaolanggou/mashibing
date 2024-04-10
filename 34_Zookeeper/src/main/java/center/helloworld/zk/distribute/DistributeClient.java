package center.helloworld.zk.distribute;

/**
 * @author zhishun.cai
 * @date 2024/3/25
 * @note
 */

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端
 */
public class DistributeClient {

    private ZooKeeper zk;

    // 连接信息
    private String connectString = "192.168.220.201:2181,192.168.220.201:2182,192.168.220.201:2183";

    // 超时时间
    private int sessionTimeOut = 30000;


    public static void main(String[] args) throws Exception {

        DistributeClient client = new DistributeClient();

        //1.获取zk连接
        client.getConnection();

        //2.监听 /servers下面所有的子节点变化
        client.getServerList();

        //3.业务逻辑
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * 获取连接
     */
    private void getConnection() throws Exception {
        zk = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //监听服务器地址的上下线
                try {
                    getServerList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 监听 /servers路径下的所有子节点变化，true表示启动监听器
     */
    private void getServerList() throws Exception {

        List<String> zkChildren = zk.getChildren("/servers", true);
        List<String> servers = new ArrayList<>();

        zkChildren.forEach(node -> {
            //拼接服务完整信息
            try {
                byte[] data = zk.getData("/servers/" + node, false, null);
                servers.add(new String(data));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println(servers);
        System.out.println("=======================");
    }
}
