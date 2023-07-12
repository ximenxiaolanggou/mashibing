package center.helloworld.rocketmq4.sample_10_filtermsg;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/7/11
 * @note SQL消息过滤生产者
 */
public class SQLFilterMsgProducer {

    public static void main(String[] args) throws MQClientException, InterruptedException, UnsupportedEncodingException, RemotingException, MQBrokerException {
        // 创建生产者对象，并传递组名称
        DefaultMQProducer producer = new DefaultMQProducer("sql_group");

        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.111.222:9876");

        // 启动Producer实例
        producer.start();
        String tags[] = {"TagA", "TagB", "TagB"};
        for (int i = 0; i < 5; i++) {
            // 创建消息对象
            Message msg = new Message(
                    "topic_sql_test_1",
                    tags[i % 3],
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );

            msg.putUserProperty("a", String.valueOf(i));

            SendResult result = producer.send(msg);
            System.out.println(result);
        }
        // 关闭
        producer.shutdown();
    }
}
