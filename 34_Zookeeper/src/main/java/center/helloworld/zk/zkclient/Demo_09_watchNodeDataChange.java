package center.helloworld.zk.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhishun.cai
 * @date 2024/3/25
 * @note 监听节点数据变化
 */

public class Demo_09_watchNodeDataChange {


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

    @Test
    public void watchNodeDataChange() {
        zkClient.subscribeDataChanges("/node3", new IZkDataListener() {

            // 当节点的值在修改时，会自动调用这个方法
            @Override
            public void handleDataChange(String nodeName, Object result) throws Exception {
                System.out.println("节点名称： " + nodeName);
                System.out.println("节点数据： " + result);
            }

            // 当节点被删除时，会调用该方法
            @Override
            public void handleDataDeleted(String nodeName) throws Exception {
                System.out.println("节点名称： " + nodeName);
            }
        });

        while(true){}
    }

    @After
    public void after(){
        zkClient.close();
    }
}
