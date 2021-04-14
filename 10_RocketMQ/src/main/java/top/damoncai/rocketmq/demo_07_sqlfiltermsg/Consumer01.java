package top.damoncai.rocketmq.demo_07_sqlfiltermsg;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.filter.MessageFilter;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

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
        MessageSelector selector = MessageSelector.bySql("age <= 5");
        consumer.subscribe("myTopic002",selector);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt message : list) {
                    System.out.println(new String(message.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.start();
        System.out.println("消费者启动完毕 ~~~");
    }
}
