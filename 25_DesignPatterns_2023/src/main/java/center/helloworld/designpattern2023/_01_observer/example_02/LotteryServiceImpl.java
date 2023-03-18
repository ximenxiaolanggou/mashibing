package center.helloworld.designpattern2023._01_observer.example_02;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhishun.cai
 * @create 2023/3/9
 * @note
 */
public class LotteryServiceImpl extends LotteryService {


    //注入摇号服务
    private DrawHouseService houseService = new DrawHouseService();

    @Override
    public LotteryResult lottery(Long uId) {
        //摇号
        String result = houseService.lots(uId);
        LotteryResult lotteryResult = new LotteryResult(uId, result, new Date());

        return lotteryResult;
    }
}
