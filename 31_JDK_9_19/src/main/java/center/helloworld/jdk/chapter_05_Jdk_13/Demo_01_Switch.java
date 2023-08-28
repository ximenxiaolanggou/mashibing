package center.helloworld.jdk.chapter_05_Jdk_13;

import center.helloworld.jdk.enums.Month;
import org.junit.Test;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 文本块
 */
public class Demo_01_Switch {

    @Test
    public void switch1() {
        String x = "3";
        int i = switch (x) {
            case "1" -> 1;
            case "2" -> 2;
            default -> {
                yield 3;
            }
        };
        System.out.println(i);
    }

    @Test
    public void switch2() {
        String x = "3";
        int i = switch (x) {
            case "1":
                yield 1;
            case "2":
                yield 2;
            default:
                yield 3;
        };
        System.out.println(i);
    }
}
