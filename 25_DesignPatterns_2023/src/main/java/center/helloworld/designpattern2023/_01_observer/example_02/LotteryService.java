package center.helloworld.designpattern2023._01_observer.example_02;

/**
 * 开奖服务接口
 */
public abstract class LotteryService {

    EventManager eventManager;

    public LotteryService() {
        //设置事件类型
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        //订阅
        eventManager.subscribe(EventManager.EventType.Message,new MessageEventListener());
        eventManager.subscribe(EventManager.EventType.MQ,new MQEventListener());
    }


    //摇号相关业务
    public LotteryResult lotteryMQAndMeaage(Long uId) {
        LotteryResult result = lottery(uId);
        //发送通知
        eventManager.notify(EventManager.EventType.Message,result);
        eventManager.notify(EventManager.EventType.MQ,result);
        return result;

    }

    //摇号相关业务
    abstract LotteryResult lottery(Long uId);
}
