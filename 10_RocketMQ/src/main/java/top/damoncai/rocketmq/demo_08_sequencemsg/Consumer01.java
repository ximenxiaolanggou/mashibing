package top.damoncai.rocketmq.demo_08_sequencemsg;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/3/23 11:01
 */

public class Consumer01 {

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("cg005");
        consumer.setNamesrvAddr("192.168.220.201:9876");

        //每个Comsumer关注一个topic

        //topic关注的消息的地址
        consumer.subscribe("myTopic003","*");

        /**
         * MessageListenerConcurrently 并发消费/开启多线程 所以不能保证消费顺序
         */
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//                for (MessageExt message : list) {
//                    System.out.println(new String(message.getBody()));
//                }
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });

        /**
         * MessageListenerOrderly 书序消费，对一个queue 开启一个线程，多个queue开多个线程
         */
        consumer.setConsumeThreadMax(5);
        consumer.setConsumeThreadMin(1);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt message : list) {
                    System.out.println(new String(message.getBody()) + " " + Thread.currentThread().getName());
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();
        System.out.println("消费者启动完毕 ~~~");
    }
}
