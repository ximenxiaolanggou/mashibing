package top.damoncai.dml;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.internals.Topic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @author zhishun.cai
 * @date 2021/2/23 8:57
 */
@Slf4j
public class TopicDMLDemo {
    KafkaAdminClient adminClient = null;

    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,node1:9092,node2:9092");
        adminClient = (KafkaAdminClient) KafkaAdminClient.create(props);
    }

    /**
     * 释放资源
     */
    @After
    public void after() {
        if(null != adminClient) adminClient.close();
    }

    /**
     * topic列表
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void topicList() throws ExecutionException, InterruptedException {
        ListTopicsResult topics = adminClient.listTopics();
        KafkaFuture<Set<String>> nameFutures = topics.names();
        for (String name : nameFutures.get()) {
            System.out.println(name);
        }
    }

    /**
     * 创建topic
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void create() throws ExecutionException, InterruptedException {
        List<NewTopic> newTopics = Arrays.asList(new NewTopic("topic04", 2, (short) 3));
        CreateTopicsResult createTopicsResult = adminClient.createTopics(newTopics);
        /**
         * 创建Topic是异步的
         * 添加createTopicsResult.all().get()可以改为同步创建Topic
         */
        createTopicsResult.all().get();
        log.info("创建Topic成功");
    }

    /**
     * 删除topic
     */
    @Test
    public void delete(){
        adminClient.deleteTopics(Arrays.asList("topic03","topic04"));
        log.info("删除Topic成功");
    }

    /**
     * topic详情
     */
    @Test
    public void describeTopics() throws ExecutionException, InterruptedException {
        DescribeTopicsResult describeTopics = adminClient.describeTopics(Arrays.asList("topic03"));
        Map<String, TopicDescription> tdm = describeTopics.all().get();
        for (Map.Entry<String, TopicDescription> entry : tdm.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
