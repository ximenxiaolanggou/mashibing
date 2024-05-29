package center.helloworld.zk.distribute;

/**
 * @author zhishun.cai
 * @date 2024/3/25
 * @note
 */

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * 服务端
 */
public class DistributeServer {

    private ZooKeeper client;

    // 连接信息
    private String connectString = "192.168.220.201:2181,192.168.220.201:2182,192.168.220.201:2183";

    // 超时时间
    private int sessionTimeOut = 30000;

    public static void main(String[] args) throws Exception {

        DistributeServer server = new DistributeServer();

        //1.获取zk连接
        server.getConnect();
        while (true);

        //2.将服务器注册到zk集群，args参数通过启动 main方法时传入即可
//        server.register(args[0]);

        //3.启动业务逻辑（线程睡眠）
//        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * 注册操作
     * @param hostName 将服务器注册到zk集群时，所需的服务名称
     */
    private void register(String hostName) throws Exception {

        /**
         * ZooDefs.Ids.OPEN_ACL_UNSAFE: 此权限表示允许所有人访问该节点（服务器）
         * CreateMode.EPHEMERAL_SEQUENTIAL: 由于服务器是动态上下线的，上线后存在，下线后不存在，所以是临时节点
         * 而服务器一般都是有序号的，所以是临时、有序的节点.
         */
        String node = client.create("/servers/" + hostName,
                hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        System.out.println("已成功创建" + node + "节点");
        System.out.println(hostName + " 已经上线");
    }


    /**
     * 获取连接
     */
    private void getConnect() throws IOException {
        client = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent);
            }
        });
    }
}
