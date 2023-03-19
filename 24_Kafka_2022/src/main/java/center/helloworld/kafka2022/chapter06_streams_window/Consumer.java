package center.helloworld.kafka2022.chapter06_streams_window;

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
 * @create 2023/2/24
 * @note
 */
public class Consumer {

    KafkaConsumer<String, String> consumer = null;

    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        //连接参数
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.220.201:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());

        props.put(ConsumerConfig.GROUP_ID_CONFIG,"stream-group");

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
//        consumer.subscribe(Pattern.compile("^topic.*$"));
        consumer.subscribe(Arrays.asList("cell3"));
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
