package top.damoncai.rocketmq.demo_03_asyncmsg;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
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
        //批量消息发送
        Message message = new Message("myTopic001", "hello world - 2".getBytes());
        //异步发送消息
        producer.send(message,new SendCallback(){
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功，listResult：" + sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                throwable.printStackTrace();
                System.err.println("发送失败");
            }
        });

//        producer.shutdown();
        System.out.println("消息发送完毕 ~~~");
    }
}
