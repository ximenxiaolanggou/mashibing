package center.helloworld.jdk.chapter_03_Jdk_11;

import center.helloworld.jdk.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 局部变量类型推断
 */
public class Demo_01_var_lambda {

    @Test
    public void test() {
        // 错误写法
        // Consumer<String> consumer = (@Deprecated t) -> System.out.println(t);

        // 正确写法
        Consumer<String> consumer = (@Deprecated var t) -> System.out.println(t);
    }

}
