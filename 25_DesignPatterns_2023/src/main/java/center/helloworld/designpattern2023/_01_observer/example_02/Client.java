package center.helloworld.designpattern2023._01_observer.example_02;

/**
 * @author zhishun.cai
 * @create 2023/3/9
 * @note
 */
public class Client {

    public static void main(String[] args) {
        LotteryServiceImpl lotteryService = new LotteryServiceImpl();

        lotteryService.lotteryMQAndMeaage(2L);

    }
}
