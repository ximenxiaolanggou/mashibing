package center.helloworld.rocketmq4.sample_07_partition_order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/7/11
 * @note 顺序生产者
 */
public class PartionOrderProducer {

    public static void main(String[] args) throws MQClientException, InterruptedException, UnsupportedEncodingException, RemotingException, MQBrokerException {
        // 创建生产者对象，并传递组名称
        DefaultMQProducer producer = new DefaultMQProducer("partion_seq_group");

        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.111.222:9876");

        // 启动Producer实例
        producer.start();

        // 同步发送10条消息
        for (int i = 0; i < 5; i++) {
            // 创建消息对象
            Message msg = new Message(
                    "topic_partion_test_1",
                    "topic_partion_test_1",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );

            producer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object arg) {
                    // 这里的arg 就是send方法第三个参数
                    int id = (int) arg;
                    return list.get(id % 2);
                }
            }, i);
        }

        // 关闭
        producer.shutdown();
    }
}
