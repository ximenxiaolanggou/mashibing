package center.helloworld.rocketmq4.sample_08_delaymsg;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/7/11
 * @note 延时消息生产者
 */
public class DelayMsgProducer {

    public static void main(String[] args) throws MQClientException, InterruptedException, UnsupportedEncodingException, RemotingException, MQBrokerException {
        // 创建生产者对象，并传递组名称
        DefaultMQProducer producer = new DefaultMQProducer("delay_group");

        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.111.222:9876");

        // 启动Producer实例
        producer.start();

        // 同步发送10条消息
        for (int i = 0; i < 5; i++) {
            // 创建消息对象
            Message msg = new Message(
                    "topic_delay_test_1",
                    "topic_delay_test_1",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            /**
             * 1	2	3	4	5	6	7	8	9
             * 1s	5s	10s	30s	1m	2m	3m	4m	5m
             * 10	11	12	13	14	15	16	17	18
             * 6m	7m	8m	9m	10m	20m	30m	1h	2h
             */
            msg.setDelayTimeLevel(5);
            producer.send(msg);
        }

        // 关闭
        producer.shutdown();
    }
}
