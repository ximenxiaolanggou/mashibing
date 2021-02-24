package top.damoncai.offset;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.*;

/**
 * @author zhishun.cai
 * @date 2021/2/23 10:44
 */

public class Consumer_guest_post {

    KafkaConsumer<String, String> consumer = null;

    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        //连接参数
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,node1:9092,node2:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        //取消自动提交
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"group02");

        //创建Topic消费者
        consumer = new KafkaConsumer<String, String>(props);
    }

    /**
     * 释放资源
     */
    @After
    public void after() {
        if(null != consumer) consumer.close();
    }

    @Test
    public void consumer() {
        //订阅Topic开头的消息队列
        consumer.subscribe(Arrays.asList("topic06"));

        while (true) {
            //每隔一秒拉取一次数据
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            Iterator<ConsumerRecord<String, String>> recordIterator = consumerRecords.iterator();
            while (recordIterator.hasNext()) {
                ConsumerRecord<String, String> record = recordIterator.next();
                String key = record.key();
                String value = record.value();
                long offset = record.offset();
                int partition = record.partition();

                /**
                 * key：TopicPartition topic + 分区
                 * value：OffsetAndMetadata offset偏移量信息
                 */

                Map<TopicPartition, OffsetAndMetadata> offsets=new HashMap<TopicPartition, OffsetAndMetadata>();

                /**
                 * 注意：提交的位置为下一个消费的位置
                 */
                offsets.put(new TopicPartition(record.topic(),record.partition()),new OffsetAndMetadata(record.offset() + 1));

                consumer.commitAsync(offsets,new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                        System.out.println("提交成功！");
                    }
                });
                System.out.println("key：" + key + ",value：" + value + ",offset：" + offset + ",partition：" + partition);
            }
        }
    }
}
