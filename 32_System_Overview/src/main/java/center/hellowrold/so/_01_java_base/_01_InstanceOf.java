package center.hellowrold.so._01_java_base;

import org.junit.Test;

/**
 * @author zhishun.cai
 * @create 2023/9/1
 * @note instanceof 测试
 */
public class _01_InstanceOf {

    @Test
    public void testInstanceof() {
        Integer num = 1;
        System.out.println(num instanceof Integer);
        System.out.println(num instanceof Object);
        System.out.println(null instanceof Object);

    }
}
