package top.damoncai.designattern.bridge;

/**
 * @author zhishun.cai
 * @date 2021/1/27 20:20
 */

public class Main {

    public static void main(String[] args) {

        IMessageSender messageSender = new EmailMessageSender();

        AbsNotification normal = new NormalNotification(messageSender);

        normal.notify("报警啦~~");
    }
}
