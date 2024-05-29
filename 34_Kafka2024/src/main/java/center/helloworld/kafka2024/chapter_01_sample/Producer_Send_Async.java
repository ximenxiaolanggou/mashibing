package center.helloworld.kafka2024.chapter_01_sample;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @author zhishun.cai
 * @create 2024/3/7
 * @note
 */
public class Producer_Send_Async {


    public static void main(String[] args) {

        // 设置属性
        Properties properties = new Properties();
        // 指定连接的kafka服务器的地址  key值可以用 ProducerConfig类中的静态属性配置 ,
        // 多个服务器逗号隔开
        properties.put("bootstrap.servers","192.168.100.88:9092");
        // 设置String的序列化
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);

        // 构建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        try {
            // 构建消息
            ProducerRecord<String,String> record = new ProducerRecord<String,String>("topic1", "key","hello2");
            // 发送消息
            // 发送消息
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null){
                        // 没有异常，输出信息到控制台
                        System.out.println("offset:"+recordMetadata.offset()+"," +"partition:"+recordMetadata.partition());
                    } else {
                        // 出现异常打印
                        e.printStackTrace();
                    }
                }
            });

            System.out.println("message is sent.");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放链接
            producer.close();
        }
    }
}
