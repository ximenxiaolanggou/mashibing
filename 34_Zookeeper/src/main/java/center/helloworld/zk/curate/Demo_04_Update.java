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
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2024/3/22
 * @note 数据修改
 */

public class Demo_04_Update {

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
     * 基本数据修改
     * @throws Exception
     */
    @Test
    public void baseUpdateData() throws Exception {
        Stat stat = client.setData().forPath("/app1", " damoncai".getBytes(StandardCharsets.UTF_8));
        System.out.println(stat);
    }

    /**
     * 根据版本修改（乐观锁）
     */
    @Test
    public void updateDataWithVersion() throws Exception {
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        int version = stat.getVersion();
        System.out.println(version);  //1

        client.setData().withVersion(version).forPath("/app1","hehe".getBytes());
    }




    @After
    public void destory() {
        client.close();
    }
}
