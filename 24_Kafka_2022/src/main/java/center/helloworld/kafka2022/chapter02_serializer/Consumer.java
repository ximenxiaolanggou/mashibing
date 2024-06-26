package center.helloworld.kafka2022.chapter02_serializer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author zhishun.cai
 * @create 2023/2/21
 * @note
 */
public class Consumer {

    public static void main(String[] args) {
        // 设置属性
        Properties properties = new Properties();
        // 指定连接的kafka服务器的地址  key值可以用 ProducerConfig类中的静态属性配置 ,
        // 多个服务器逗号隔开
        properties.put("bootstrap.servers","192.168.220.201:9092");
        // 设置String的序列化
        properties.put("key.deserializer", StringDeserializer.class);
        properties.put("value.deserializer", ObjectDeserializer.class);
        //properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        properties.put("group.id","group05");

        // 构建kafka生产者对象
        KafkaConsumer<String, User> consumer = new KafkaConsumer<>(properties);
        try {
            // 订阅主题
            consumer.subscribe(Collections.singleton("test"));
            while (true) {
                ConsumerRecords<String, User> records = consumer.poll(Duration.ofSeconds(1L));
                for (ConsumerRecord<String, User> record : records) {
                    String key = record.key();
                    String topic = record.topic();
                    int partition = record.partition();
                    User value = record.value();
                    long offset = record.offset();
                    System.out.println("record begin =========");
                    System.out.println("topic: " + topic);
                    System.out.println("partition: " + partition);
                    System.out.println("offset: " + offset);
                    System.out.println("key: " + key);
                    System.out.println("value: " + value);
                    System.out.println("record end   =========");
                }
            }

        }finally {
            // 释放链接
            consumer.close();
        }
    }
}
