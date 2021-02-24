package top.damoncai.designattern.bridge;

/**
 * @author zhishun.cai
 * @date 2021/1/27 20:18
 */

public class SerereNotification extends AbsNotification {

    public SerereNotification(IMessageSender iMessageSender) {
        super(iMessageSender);
    }

    @Override
    void notify(String message) {
        iMessageSender.sendMessage("严重消息" + message);
    }
}
