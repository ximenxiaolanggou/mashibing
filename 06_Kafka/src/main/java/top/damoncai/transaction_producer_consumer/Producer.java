package top.damoncai.transaction_producer_consumer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;
import java.util.UUID;

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

        // ACKS 设置为all
        props.put(ProducerConfig.ACKS_CONFIG,"all");
        //尝试次数设置3 一共四次（可以去掉使用默认）
        props.put(ProducerConfig.RETRIES_CONFIG,3);
        //问答时间设置为1ms(测试)
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,20000);

        //开启kafka幂等性
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);
        //设置阻塞等待数量 设置为 1 确保顺序
        props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,1);

        //配置kafka批处理大小
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,1024);
        //等待5ms如果batch中的数据不足1024大小
        props.put(ProducerConfig.LINGER_MS_CONFIG,5);

        //必须配置事务ID，必须是唯一的
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"transaction-id " + UUID.randomUUID().toString());

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
        producer.initTransactions();
        try {
            producer.beginTransaction();
            for(int i = 0 ; i < 5 ; i++) {
//                if(i == 3) throw new RuntimeException("出错啦~~");
                ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("topic02","acks" + 1,"test acks");
                producer.send(producerRecord);
                producer.flush();
            }
        producer.commitTransaction();
        }catch (Exception e) {
            System.err.println("出现错误");
            producer.abortTransaction();
        }
    }
}
