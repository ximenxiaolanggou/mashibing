package top.damoncai.rocketmq.demo_01_helloword;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/3/23 10:53
 */

public class Producer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg001");

        //设置nameserver地址
        producer.setNamesrvAddr("192.168.220.201:9876");
//        producer.setSendMsgTimeout(6000);
        producer.start();

        //topic 消息发送的主题
        //body 消息发送的内容
        Message message = new Message("myTopic001", "hello world - 1".getBytes());

        //同步发送消息
        SendResult result = producer.send(message);

        System.out.println("result：" + result);

        producer.shutdown();
        System.out.println("消息发送完毕 ~~~");
    }
}
