package center.helloworld.designpattern2023._01_observer.example_02;

/**
 * @author zhishun.cai
 * @create 2023/3/9
 * @note MQ监听者
 */
public class MQEventListener implements EventListener{
    @Override
    public void doEvent(LotteryResult lotteryResult) {
        System.out.println("MQ提醒：" + lotteryResult.toString());
    }
}
