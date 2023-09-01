package center.helloworld.jdk.chapter_06_Jdk_14;

import org.junit.Test;

import java.util.Date;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note switch 成为标准
 */
public class Demo_02_Switch {

    @Test
    public void switchDemo() {
        String x = "2";
        var i = switch (x) {
            case "1" -> 1;
            case "2" -> new Date();
            default -> {
                yield 3;
            }
        };
        System.out.println(i);

    }
}
