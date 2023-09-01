package center.helloworld.jdk.chapter_06_Jdk_14;

import org.junit.Test;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note instanceof
 */
public class Demo_01_Instanceof {

    @Test
    public void instancof() {
        Object obj = "hello world";
        if(obj instanceof String str && str.length() > 2) {
            System.out.println("是字符串，并且长度大于2");
        }

    }
}
