package top.damoncai.rocketmq.demo_01_helloword;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/3/23 11:01
 */

public class Consumer {

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("cg001");
        consumer.setNamesrvAddr("192.168.220.201:9876");

        //每个Comsumer关注一个topic

        //topic关注的消息的地址
        //过滤器 * 表示不过滤
        consumer.subscribe("myTopic001","*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                System.out.println("len：" + list.size());
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
