package top.damoncai.rocketmq.demo_04_onewaymsg;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

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
        Message message = new Message("myTopic001", "hello world - 2".getBytes());
        producer.sendOneway(message);

//        producer.shutdown();
        System.out.println("消息发送完毕 ~~~");
    }
}
