package top.damoncai.designattern.bridge;

/**
 * @author zhishun.cai
 * @date 2021/1/27 20:13
 */

public class EmailMessageSender implements IMessageSender {
    @Override
    public void sendMessage(String msg) {
        System.out.println("邮件发送:" + msg);
    }
}
