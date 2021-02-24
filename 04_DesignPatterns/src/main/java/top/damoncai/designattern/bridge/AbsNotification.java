package top.damoncai.designattern.bridge;

/**
 * @author zhishun.cai
 * @date 2021/1/27 20:16
 */

public  abstract class AbsNotification {

    IMessageSender iMessageSender;

    public AbsNotification(IMessageSender iMessageSender) {
        this.iMessageSender = iMessageSender;
    }

    abstract void notify(String message);

}
