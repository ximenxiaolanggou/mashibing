package center.helloworld.kafka2022.chapter03_partitioner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author zhishun.cai
 * @create 2023/2/21
 * @note 生产者
 */
public class Producer {

    public static void main(String[] args) {

        // 设置属性
        Properties properties = new Properties();
        // 指定连接的kafka服务器的地址  key值可以用 ProducerConfig类中的静态属性配置 ,
        // 多个服务器逗号隔开
        properties.put("bootstrap.servers","192.168.220.201:9092");
        // 设置String的序列化
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);
        //设置自定义分区
        properties.put("partitioner.class",UserDefinedPartitioner.class);

        // 构建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        try {
            // 构建消息
            ProducerRecord<String,String> record = new ProducerRecord<String,String>("test",0, "key","hello");
            // 发送消息
            producer.send(record);

            System.out.println("message is sent.");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放链接
            producer.close();
        }
    }
}
