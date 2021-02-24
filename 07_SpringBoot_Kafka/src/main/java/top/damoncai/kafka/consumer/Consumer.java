package top.damoncai.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhishun.cai
 * @date 2021/2/24 9:34
 */

@RestController
@RequestMapping("/consumer")
public class Consumer {

    @Autowired
    private KafkaTemplate<String,String> template;

    @KafkaListeners(value = {@KafkaListener(topics = {"topic01"})})
    @SendTo(value = {"topic02"})
    public String listenner(ConsumerRecord<?, ?> record) {
        return record.value()+" mashibing edu";
    }

    @KafkaListeners(value = {@KafkaListener(topics = {"topic02"})})
    public void listenner2(ConsumerRecord<?, ?> record) {
        System.err.println("msg: " + record.value());
    }

    @KafkaListeners(value = {@KafkaListener(topics = {"topic03"})})
    public void listenner3(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {
        try {
            int i = 1/0;
            System.err.println("msg: " + record.value());
        }catch (Exception e) {
            System.err.println("消费 Error");
        }finally {
            /**
             * 手动确认事务
             */
            acknowledgment.acknowledge();
        }
    }
}
