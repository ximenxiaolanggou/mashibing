package top.damoncai.rocketmq.demo_09_txmsg;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/3/23 11:01
 */

public class Consumer01 {

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("cg001");
        consumer.setNamesrvAddr("192.168.220.201:9876");

        //每个Comsumer关注一个topic

        //topic关注的消息的地址
        consumer.subscribe("myTopic003","*");

        /**
         * MessageListenerConcurrently 并发消费/开启多线程 所以不能保证消费顺序
         */
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt message : list) {
                    System.out.println(new String(message.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();
        System.out.println("消费者启动完毕 ~~~");
    }
}
