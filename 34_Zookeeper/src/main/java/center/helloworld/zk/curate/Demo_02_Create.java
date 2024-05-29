package center.helloworld.zk.curate;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author zhishun.cai
 * @date 2024/3/22
 * @note
 */

public class Demo_02_Create {

    private CuratorFramework client;

    @Before
    public void connect() {
        /**
         * String connectString     连接字符串。 zk地址和端口： "192.168.58.100:2181,192.168.58.101:2181"
         * int sessionTimeoutMs     会话超时时间 单位ms
         * int connectionTimeoutMs  连接超时时间 单位ms
         * RetryPolicy retryPolicy  重试策略
         */
        //1. 第一种方式

        //重试策略 baseSleepTimeMs 重试之间等待的初始时间，maxRetries 重试的最大次数
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000,10);


        //2. 第二种方式，建造者方式创建
        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.220.201:2181")
                .sessionTimeoutMs(60*1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryPolicy)
                .namespace("damon")  //根节点名称设置
                .build();

        //开启连接
        client.start();
    }

    @Test
    public void createNode() throws Exception {
        String path = client.create().forPath("/app1");
        System.out.println(path);
    }

    /**
     * 创建带数据的节点
     */
    @Test
    public void createNodeWithData() throws Exception{
        String path = client.create().forPath("/app2", "hello".getBytes(StandardCharsets.UTF_8));
        System.out.println(path);
    }

    /**
     * 设置节点类型 默认持久化
     */
    @Test
    public void createNodeWithType() throws Exception {
        String path = client.create().withMode(CreateMode.EPHEMERAL).forPath("/app3", "hello world".getBytes(StandardCharsets.UTF_8));
        System.out.println(path);
        // 因为是非持久化节点，需要先阻塞才可以查看
        System.in.read();
    }

    @After
    public void destory() {
        client.close();
    }
}
