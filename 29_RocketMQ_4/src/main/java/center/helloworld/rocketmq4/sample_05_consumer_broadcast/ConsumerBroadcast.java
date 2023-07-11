package center.helloworld.rocketmq4.sample_05_consumer_broadcast;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/7/11
 * @note 广播消费
 */
public class ConsumerBroadcast {

    public static void main(String[] args) throws MQClientException {
        // 实例化消费者，并指定组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_group");

        // 指定NameSrv地址信息
        consumer.setNamesrvAddr("192.168.111.222:9876");

        // 订阅主题
        consumer.subscribe("topic_test_1", "*");

        // 设置负载均衡消费模式（可以不设置，默认就是负载均衡）
        consumer.setMessageModel(MessageModel.BROADCASTING);

        // 注册回调函数，处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                try {
                    for (MessageExt msg : msgs) {

                        String topic = msg.getTopic();
                        String msgBody = new String(msg.getBody(), "utf-8");
                        String tags = msg.getTags();
                        System.out.println("topic: " + topic + ", tags：" + tags + ", msg: " + msgBody);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动
        consumer.start();
    }

}
