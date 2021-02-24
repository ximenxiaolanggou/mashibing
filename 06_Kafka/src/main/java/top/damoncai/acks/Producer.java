package top.damoncai.acks;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

/**
 * @author zhishun.cai
 * @date 2021/2/23 10:48
 */

public class Producer {

    KafkaProducer<String, String> producer = null;

    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,node1:9092,node2:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        //ACK问答时长
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,1);
        //ACKS
        props.put(ProducerConfig.ACKS_CONFIG,"-1");
        //发送失败响应次数
        props.put(ProducerConfig.RETRIES_CONFIG,10);
        producer = new KafkaProducer<String, String>(props);
    }

    /**
     * 释放资源
     */
    @After
    public void after() {
        if(null != producer) producer.close();
    }

    @Test
    public void producer() throws InterruptedException {
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("topic02","acks","test acks");
        producer.send(producerRecord);
    }
}
