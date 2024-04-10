package center.helloworld.zk.curate;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.framework.api.transaction.CuratorOp;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author zhishun.cai
 * @date 2024/3/22
 * @note 异步操作
 */

public class Demo_08_Async {

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
     * 异步操作
     * @throws Exception
     */
    @Test
    public void async() throws Exception {
        while(true){

            // 异步获取子节点列表
            GetChildrenBuilder builder = client.getChildren();
            builder.inBackground(new BackgroundCallback() {
                @Override
                public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                    System.out.println("子节点列表：" + curatorEvent.getChildren());
                }
            }).forPath("/");

            TimeUnit.SECONDS.sleep(5);
        }
    }



    @After
    public void destory() {
        client.close();
    }
}
