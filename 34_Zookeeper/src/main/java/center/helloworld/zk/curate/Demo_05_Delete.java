package center.helloworld.zk.curate;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author zhishun.cai
 * @date 2024/3/22
 * @note 删除节点
 */

public class Demo_05_Delete {

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

    /**
     * 删除单个节点
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {
        client.delete().forPath("/app2");
    }

    /**
     * 删除带子节点的节点
     * @throws Exception
     */
    @Test
    public void deleteWithChildren() throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath("/app2");
    }

    /**
     * 必须删除成功（超时情况下，重试删除）
     * @throws Exception
     */
    @Test
    public void deleteUtilSuccess() throws Exception {
        client.delete().guaranteed().forPath("/app2");
    }

    /**
     * 回调 删除完成后执行
     */
    @Test
    public void deleteCallback() throws Exception {
        client.delete().guaranteed().inBackground((curatorFramework, curatorEvent) -> {
            System.out.println("我被删除了");
            System.out.println(curatorEvent);
        }).forPath("/app1");
    }




    @After
    public void destory() {
        client.close();
    }
}
