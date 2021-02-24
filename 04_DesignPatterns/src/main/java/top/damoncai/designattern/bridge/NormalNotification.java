package top.damoncai.designattern.bridge;

/**
 * @author zhishun.cai
 * @date 2021/1/27 20:18
 */

public class NormalNotification extends AbsNotification {

    public NormalNotification(IMessageSender iMessageSender) {
        super(iMessageSender);
    }

    @Override
    void notify(String message) {
        iMessageSender.sendMessage("普通消息" + message);
    }
}
