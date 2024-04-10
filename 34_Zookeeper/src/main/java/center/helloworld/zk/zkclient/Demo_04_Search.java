package center.helloworld.zk.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author zhishun.cai
 * @date 2024/3/25
 * @note 查询子节点
 */

public class Demo_04_Search {


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
    public void searchNode() {
        //返回指定路径的节点信息
        List<String> ch = zkClient.getChildren("/");

        for (String c1 : ch) {
            System.out.println(c1);
        }
    }

    @After
    public void after(){
        zkClient.close();
    }
}
