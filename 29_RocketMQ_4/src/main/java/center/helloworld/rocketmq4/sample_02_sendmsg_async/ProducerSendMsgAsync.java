package center.helloworld.rocketmq4.sample_02_sendmsg_async;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author zhishun.cai
 * @create 2023/7/11
 * @note 生产者异步发送消息
 */
public class ProducerSendMsgAsync {

    // 组名
    String groupName = "test_1";

    // 生产者对象
    DefaultMQProducer producer;

    @Before
    public void init() throws MQClientException {
        // 创建生产者对象，并传递组名称
        producer = new DefaultMQProducer(groupName);

        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.111.222:9876");

        // 启动Producer实例
        producer.start();
    }


    @Test
    public void sendMsgSync() throws UnsupportedEncodingException, MQBrokerException, RemotingException, InterruptedException, MQClientException {
        // 同步发送10条消息
        for (int i = 0; i < 5; i++) {
            // 创建消息对象
            Message msg = new Message(
                    "topic_test_1",
                    "tag_test_1",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("发送失败~~");
                }
            });

        }

        Thread.sleep(5000);
    }

    @After
    public void close() {
        // 如果不再发送消息，就关闭Producer实例
        producer.shutdown();
    }
}
