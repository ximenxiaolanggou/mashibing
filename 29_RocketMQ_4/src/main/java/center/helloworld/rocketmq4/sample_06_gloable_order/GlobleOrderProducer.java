package center.helloworld.rocketmq4.sample_06_gloable_order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author zhishun.cai
 * @create 2023/7/11
 * @note 顺序生产者
 */
public class GlobleOrderProducer {

    public static void main(String[] args) throws MQClientException, InterruptedException, UnsupportedEncodingException, RemotingException, MQBrokerException {
        // 创建生产者对象，并传递组名称
        DefaultMQProducer producer = new DefaultMQProducer("gloable_seq_group");

        // 通过设置队列数量来保证消息的有序性，不推荐，视情况而定，需要在业务和性能中做出取舍
        producer.setDefaultTopicQueueNums(1);

        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.111.222:9876");

        // 启动Producer实例
        producer.start();

        // 同步发送10条消息
        for (int i = 0; i < 5; i++) {
            // 创建消息对象
            Message msg = new Message(
                    "topic_gloable_test_1",
                    "topic_gloable_test_1",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 需要注意的是这里只能同步发送，应为异步发送和单向发送会不能保证投递到队列中的顺序
            producer.send(msg);
        }
        Thread.sleep(5000);

        // 关闭
        producer.shutdown();
    }
}
