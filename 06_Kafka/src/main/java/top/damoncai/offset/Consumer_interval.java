package top.damoncai.offset;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author zhishun.cai
 * @date 2021/2/23 10:44
 */

public class Consumer_interval {

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
        //开启自动提交 + 时间间隔(多长时间后自动提交)
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,10000);
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
                System.out.println("key：" + key + ",value：" + value + ",offset：" + offset + ",partition：" + partition);
            }
        }
    }
}
