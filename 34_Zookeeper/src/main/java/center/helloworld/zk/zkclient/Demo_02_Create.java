package center.helloworld.zk.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhishun.cai
 * @date 2024/3/25
 * @note 创建节点
 */

public class Demo_02_Create {


    private String connectString = "192.168.220.201:2181,192.168.220.202:2182,192.168.220.203:2183";
    private int sessionTimeout = 2000;

    private ZkClient zkClient;

    /**
     * 获取zk客户端连接
     */
    @Before
    public void Before(){

        /**
         * 参数1：服务器的IP和端口
         * 参数2：会话的超时时间
         * 参数3：会话的连接时间
         * 参数4：序列化方式
         */
        zkClient = new ZkClient(connectString, sessionTimeout, 1000 * 15, new SerializableSerializer());

    }

    /**
     * 创建节点
     */
    @Test
    public void createNode() {
        //创建方式 返回创建节点名称
        String nodeName = zkClient.create("/node1", "lisi", CreateMode.PERSISTENT);
        System.out.println("路径名称为：" + nodeName);

        zkClient.create("/node2","wangwu",CreateMode.PERSISTENT_SEQUENTIAL);
        zkClient.create("/node3","hehe",CreateMode.EPHEMERAL);
        zkClient.create("/node4","haha",CreateMode.EPHEMERAL_SEQUENTIAL);

        while(true){}
    }

    @After
    public void after(){
        zkClient.close();
    }
}
