import cn.hutool.core.date.DateTime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/6/8
 * @note
 */
public class Test {




    public static List<LocalDateTime> generateSearchTimeHorizon(int intervalPoint) {
        if(intervalPoint < 0 || intervalPoint > 23) {
            throw new RuntimeException("时间点为 0 ~ 23");
        }
        List<LocalDateTime> timeHorizon = new ArrayList<>(2);
        //1. 获取当天时间的八点
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        LocalDateTime curEight = LocalDateTime.of(now.getYear(),now.getMonth(),now.getDayOfMonth(),intervalPoint,0,0);
        //2. 8点前(前一天八点 [起始]) 或者 8点后(后一天八点 [截止])
        if(hour < intervalPoint ) {
            LocalDateTime preDayEight = curEight.minusDays(1L);
            timeHorizon.add(preDayEight);
            timeHorizon.add(curEight);
        }else {
            LocalDateTime sufDayEight = curEight.plusDays(1L);
            timeHorizon.add(curEight);
            timeHorizon.add(sufDayEight);
        }
        return timeHorizon;
    }

    public static void main(String[] args) {
        System.out.println(DateTime.of(1686540670000L));
    }
}
