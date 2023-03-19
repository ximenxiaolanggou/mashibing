package center.helloworld.kafka2022.chapter06_streams_window;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

/**
 * @author zhishun.cai
 * @create 2023/2/24
 * @note
 */
public class Producer {

    KafkaProducer<String, String> producer = null;

    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.220.201:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        producer = new KafkaProducer<String, String>(props);
    }

    /**
     * 释放资源
     */
    public void after() {
        if(null != producer) producer.close();
    }

    @Test
    public void producer() throws InterruptedException {
        String[] words = {"hello java", "hello scala", "java good","python script"};
        for(int i = 0 ; i < 10 ; i++) {
            Thread.sleep(100);
            int index = (int)(Math.random() * words.length);
            ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("window-input","key" + i,words[index]);
            producer.send(producerRecord);
        }
    }
}
