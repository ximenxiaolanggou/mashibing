package center.helloworld.designpattern2023._01_observer.example_02;

/**
 * @author zhishun.cai
 * @create 2023/3/9
 * @note 短信监听者
 */
public class MessageEventListener implements EventListener{
    @Override
    public void doEvent(LotteryResult lotteryResult) {
        System.out.println("短信提醒：" + lotteryResult.toString());
    }
}
