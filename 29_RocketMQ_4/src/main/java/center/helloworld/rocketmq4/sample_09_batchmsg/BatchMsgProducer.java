package center.helloworld.rocketmq4.sample_09_batchmsg;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/7/11
 * @note 延时消息生产者
 */
public class BatchMsgProducer {

    public static void main(String[] args) throws MQClientException, InterruptedException, UnsupportedEncodingException, RemotingException, MQBrokerException {
        // 创建生产者对象，并传递组名称
        DefaultMQProducer producer = new DefaultMQProducer("batch_group");

        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.111.222:9876");

        // 启动Producer实例
        producer.start();

        List<Message> msgs = Arrays.asList(
            // 创建消息对象
            new Message("topic_batch_test_1", "topic_batch_test_1", ("Hello RocketMQ 1").getBytes(RemotingHelper.DEFAULT_CHARSET)),
            new Message("topic_batch_test_2", "topic_batch_test_1", ("Hello RocketMQ 1").getBytes(RemotingHelper.DEFAULT_CHARSET)),
            new Message("topic_batch_test_3", "topic_batch_test_1", ("Hello RocketMQ 1").getBytes(RemotingHelper.DEFAULT_CHARSET))
        );

        // 批量发送
        producer.send(msgs);
        // 关闭
        producer.shutdown();
    }
}
