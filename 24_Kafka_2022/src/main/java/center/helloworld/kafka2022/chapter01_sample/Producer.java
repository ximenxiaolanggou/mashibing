package center.helloworld.kafka2022.chapter01_sample;

import cn.hutool.json.JSONUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
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
        properties.put("bootstrap.servers","192.168.111.61:32217");
        // 设置String的序列化
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);

        // 构建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        try {
            // 构建消息
            HashMap<Object, Object> map = new HashMap<>();
            map.put("moldId","asd");
            map.put("cycleTimestamp","2023-03-27");
            map.put("senId","asd");
            map.put("monId","asd");
            map.put("monType","asd");
            ProducerRecord<String,String> record = new ProducerRecord<String,String>("topic-saved-dataSensorMonitor",0, "key", JSONUtil.toJsonStr(map));
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
