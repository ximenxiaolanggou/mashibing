package top.damoncai.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.transaction.annotation.Transactional;
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

    @KafkaListeners(value = {@KafkaListener(topics = {"topic05"})})
    public void listenner2(ConsumerRecord<?, ?> record) {
        Object key = record.key();
        System.err.println("key：" + key + " msg: " + record.value());

    }

    @KafkaListeners(value = {@KafkaListener(topics = {"topic-curve-cycle"},groupId = "grouop-curve-cycle-save")})
    public void curveCycleListener(ConsumerRecord<?, ?> record,Acknowledgment acknowledgment) {
        System.out.println("==============Cycle==============");
        long offset = record.offset();
        String key = (String) record.key();
        String value = (String) record.value();
        System.out.println("offset：" + offset);
        System.out.println("key：" + key);
        System.out.println("value：" + value);
        acknowledgment.acknowledge();
    }

    @KafkaListeners(value = {@KafkaListener(topics = {"topic-curve-sensor"},groupId = "grouop-curve-sensor-save")})
    public void curveSensorListener(ConsumerRecord<?, ?> record,Acknowledgment acknowledgment) {
        System.out.println("==============Sensor==============");
        long offset = record.offset();
        String key = (String) record.key(); // VPN
        String value = (String) record.value(); // 数据

        System.out.println("offset：" + offset);
        System.out.println("key：" + key);
        System.out.println("value：" + value);

        try {
            // TODO 存储业务
            acknowledgment.acknowledge();
        }catch (Exception e) {
            // TODO SAVE_OR_UPDATE（保存 存储失败数据的偏移量）
            throw e;
        }
    }



    @KafkaListeners(value = {@KafkaListener(topics = {"topic04"})})
    public void listenner3(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {
        long offset = record.offset();
        String key = (String) record.key();
        String value = (String) record.value();
        if("key3".equals(key)) {
            System.out.println("Auth：" + key + " - offset" + offset);
        }else {
            System.out.println("UnAuth ~~ " + key + " - offset" + offset);
        }
        acknowledgment.acknowledge();

//        try {
//            if(key.equals("key3")) {
//                throw new RuntimeException("Err");
//            }
//            System.err.println("msg: " +  key + " - " + record.value());
//        }catch (Exception e) {
//            System.err.println("消费 Error: " + key + " - " + value);
//        }finally {
//            /**
//             * 手动确认事务
//             */
////            acknowledgment.acknowledge();
//        }
//        acknowledgment.acknowledge();
    }

    public static void main(String[] args) {
        System.out.println("16:15:20.307 [main] DEBUG oraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaag.springframework.test.context.junit4.SpringJUnit4ClassRunner - SpringJUnit4ClassRunner constructor called with [class TestDemo]".length());
    }

    @KafkaListeners(value = {@KafkaListener(topics = {"topic-test"})})
    public void damo(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {
        long offset = record.offset();
        String key = (String) record.key();
        String value = (String) record.value();
        System.out.println("value：" + value);
        acknowledgment.acknowledge();
    }
}
