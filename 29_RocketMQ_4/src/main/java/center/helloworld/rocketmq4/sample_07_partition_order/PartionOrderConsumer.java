package center.helloworld.rocketmq4.sample_07_partition_order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/7/11
 * @note 顺序消费案例
 */
public class PartionOrderConsumer {

    public static void main(String[] args) throws MQClientException {
        // 实例化消费者，并指定组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("partion_seq_group");

        // 指定NameSrv地址信息
        consumer.setNamesrvAddr("192.168.111.222:9876");

        // 订阅主题
        consumer.subscribe("topic_partion_test_1", "*");

        // 设置负载均衡消费模式（可以不设置，默认就是负载均衡）
        consumer.setMessageModel(MessageModel.CLUSTERING);

        // 注册回调函数，处理消息
        /**
         * MessageListenerConcurrently 并发消费/开启多线程 所以不能保证消费顺序
         */
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//                try {
//                    for (MessageExt msg : msgs) {
//                        int queueId = msg.getQueueId();
//
//                        String topic = msg.getTopic();
//                        String msgBody = new String(msg.getBody(), "utf-8");
//                        String tags = msg.getTags();
//                        System.out.println(  Thread.currentThread().getName() + ", topic: " + topic + ", tags：" + tags + ", msg: " + msgBody + ", qid: " + queueId);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
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

        // 启动
        consumer.start();
    }
}
