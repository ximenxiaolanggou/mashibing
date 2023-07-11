package center.helloworld.netty.chapter_04_handler;

import cn.hutool.http.HttpUtil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zhishun.cai
 * @create 2023/5/16
 * @note
 */
public class Test {

    public static void main(String[] args) {
//        String url = "https://localhost:20000/api/pedestal/basePedestal/getSteamPedestalCode";
//        String url2 = "https://localhost:20000/api/spray-conserve/postData";
//        String res1 = HttpUtil.get(url);
//        System.out.println(res1);
//        String res2 = HttpUtil.post(url2, new HashMap<>());
//        System.out.println(res2);

//        BigDecimal arg1 = BigDecimal.valueOf(1.24);
//        BigDecimal arg2 = BigDecimal.valueOf(4048.784);
//        arg1.divide(arg2);
//        System.out.println(arg1.compareTo(arg2));

        List<Integer> l1 = new ArrayList<>();



        BigDecimal arg1 = BigDecimal.valueOf(1.24);
        arg1.add(BigDecimal.valueOf(1));
        System.out.println(arg1.doubleValue());


    }

    public static BigDecimal sqrt(BigDecimal value, int scale){
        BigDecimal num2 = BigDecimal.valueOf(2);
        int precision = 100;
        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
        BigDecimal deviation = value;
        int cnt = 0;
        while (cnt < precision) {
            deviation = (deviation.add(value.divide(deviation, mc))).divide(num2, mc);
            cnt++;
        }
        deviation = deviation.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return deviation;
    }

    public static void getshard(double max, double min){

        double dv = max - min;
        double period = getPeriod(dv);

        int high = getDeep(max, period);
        int deep = getDeep(min, period);
        System.out.println("period:" + period);
        System.out.println("high:" + high);
        System.out.println("deep:" + deep);

    }

    static int getDeep(Double target, Double period) {
        int deep = 0;
        double high = 0.0;
        if(target > 0) {
            while (high <= target) {
                deep ++;
                high += period;
            }
        }else {
            while (high >= target) {
                deep ++;
                high -= period;
            }
        }

        return deep;

    }

    public static double getPeriod(double dv) {
        if(dv <= 1)
            return  0.1;
        if(dv <= 5)
            return 1.0;
        if(dv <= 10)
            return 2.0;
        if(dv <= 50)
            return 10.0;
        if(dv <= 100)
            return 20.0;
        if(dv <= 500)
            return 100.0;
        if(dv <= 1000)
            return 200.0;
        if(dv <= 5000)
            return 1000.0;
        if(dv <= 10000)
            return 5000.0;
        if(dv <= 50000)
            return 10000.0;

        return 0;
    }
}
