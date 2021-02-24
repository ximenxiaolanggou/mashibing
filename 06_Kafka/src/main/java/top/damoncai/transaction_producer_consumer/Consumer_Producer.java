package top.damoncai.transaction_producer_consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.*;

/**
 * @author zhishun.cai
 * @date 2021/2/23 10:44
 */

public class Consumer_Producer {

    KafkaConsumer<String, String> consumer = null;
    KafkaProducer<String, String> producer = null;


    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        //消费者
        initConsumer();
        //生产者
        initProducer();
    }

    private void initConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,node1:9092,node2:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        props.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG,"read_committed");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"group02");

        //创建Topic消费者
        consumer = new KafkaConsumer<String, String>(props);
    }

    private void initProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,node1:9092,node2:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        //必须配置事务ID，必须是唯一的
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"transaction-id");

        //创建Topic消费者
        producer = new KafkaProducer<String, String>(props);
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
        consumer.subscribe(Arrays.asList("topic02"));
        producer.initTransactions();
        while (true) {
            //每隔一秒拉取一次数据
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            Iterator<ConsumerRecord<String, String>> recordIterator = consumerRecords.iterator();
            while (recordIterator.hasNext()) {
                producer.beginTransaction();
                Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
                ConsumerRecord<String, String> record = recordIterator.next();

                //创建Record
                ProducerRecord<String,String> producerRecord=new ProducerRecord<String,String>("topic03",record.key(),record.value());
                producer.send(producerRecord);
                //"Topic03",key + " - Consumer_Producer",value + " - Consumer_Producer"
                offsets.put(new TopicPartition(record.topic(),record.partition()),
                        new OffsetAndMetadata(record.offset() + 1));
                producer.sendOffsetsToTransaction(offsets,"group02");
                producer.commitTransaction();
            }
        }
    }
}
