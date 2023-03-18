package center.helloworld.kafka2022.chapter04_intercpetors;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author zhishun.cai
 * @create 2023/2/24
 * @note
 */
public class UserDefinedProducerInterceptor implements ProducerInterceptor {
    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        ProducerRecord producerRecord = new ProducerRecord(record.topic(), record.key(), record.value() + "782099197@qq.com");
        return producerRecord;
    }

    /**
     * 无论是正确还是异常都会进入该方法
     * @param recordMetadata
     * @param e
     */
    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        System.out.println("metadata:"+recordMetadata+",exception:"+e);
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println("configure");
    }
}
