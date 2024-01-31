package center.hellowrold.jvm.chapter07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/11/3
 * @note 比例测试
 */
public class Demo_02_TestRate {

    public static void main(String[] args) throws InterruptedException {
        List<Byte[]> list = new ArrayList();
        while (true) {
            Thread.sleep(10);
            list.add(new Byte[1024 * 1024 * 10]); // 10m
        }
    }
}
