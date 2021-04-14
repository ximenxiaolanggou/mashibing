package top.damoncai.rocketmq.demo_09_txmsg;

import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
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
        TransactionMQProducer producer = new TransactionMQProducer("pg001");

        //设置nameserver地址
        producer.setNamesrvAddr("192.168.220.201:9876");

        // 回调
        producer.setTransactionListener(new TransactionListener() {

            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                // 执行 本地事务


                System.out.println("=====executeLocalTransaction");
                System.out.println("msg:" + new String(msg.getBody()));
                System.out.println("msg:" + msg.getTransactionId());

                /**
                 *
                 * 事务方法 写这里
                 *
                 * 同步执行
                 * -----a----
                 * a 提交注册信息()  ;
                 * b 写入数据库();
                 * c 新用户() -> 发消息;
                 *
                 * 事务消息的应用场景是不是适合发送多个消息要保证同时成功或失败？
                 *
                 * ----b----
                 *
                 * 读取消息
                 * 拿到新用户的信息 发短信
                 *
                 *
                 * 那如果最后一个commit发送失败，
                 * 业务的事务 异常， 然后broker等超时回调检查 发现失败，就扔掉数据是吗？
                 *
                 *
                 */
                try {

                    // 业务
                } catch (Exception e) {
                    //
                    System.out.println("错误");
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }
                // 真正发出去的数据 可用
                return LocalTransactionState.COMMIT_MESSAGE;
            }

            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                // Broker 端 回调 ，检查事务

                System.out.println("=====checkLocalTransaction");
                System.out.println("msg:" + new String(msg.getBody()));
                System.out.println("msg:" + msg.getTransactionId());




                // 事务执行成功
                return LocalTransactionState.COMMIT_MESSAGE;
                // 等会儿
                //		return LocalTransactionState.UNKNOW;
                // 回滚消息
                //		return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        });




        producer.start();

        //topic 消息发送的主题
        //body 消息发送的内容
        Message message = new Message("myTopic003", ("hello world - Tag ").getBytes());
        producer.sendMessageInTransaction(message,null);
        producer.shutdown();
        System.out.println("消息发送完毕 ~~~");
    }
}
