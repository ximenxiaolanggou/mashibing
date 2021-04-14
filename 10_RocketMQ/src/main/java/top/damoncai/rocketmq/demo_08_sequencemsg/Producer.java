package top.damoncai.rocketmq.demo_08_sequencemsg;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/3/23 10:53
 */

public class Producer {


    /**
     *
     * 顺序消费：
     *  1.同一个Topic
     *  2.同一个队列
     *  3.同一个线程存放数据
     *  4.同一个线程取出数据
     *
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg001");

        //设置nameserver地址
        producer.setNamesrvAddr("192.168.220.201:9876");
//        producer.setSendMsgTimeout(6000);
        producer.start();

        //topic 消息发送的主题
        //body 消息发送的内容
        for (int i = 1 ; i <= 11 ; i++) {
            Message message = new Message("myTopic003", ("hello world - Tag - B " + i).getBytes());
            producer.send(message, new MessageQueueSelector() {

                /**
                 * list 队列集合
                 * message send方法中传递的Message
                 * o send方法中arg参数
                 * @param list
                 * @param message
                 * @param o
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    //向同一个队列中存放数据
                    Integer index = (int) o;
                    return list.get(index);
                }
            },0,3000);
        }
        producer.shutdown();
        System.out.println("消息发送完毕 ~~~");
    }
}
