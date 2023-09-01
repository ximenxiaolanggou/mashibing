package center.helloworld.jdk.chapter_03_Jdk_11;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 字符串新增方法
 */
public class Demo_02_String {

    @Test
    public void test() {
        // isBlank
        System.out.println(" ".isBlank());

        // 去除前尾空格
        System.out.println(" hello java ".strip());

        // 也可以去除转义字符
        System.out.println(" \thello java\n ".strip());

        // 去除字符串尾部空格
        System.out.println(" \thello java\n ".stripTrailing());

        // 去除首部空格
        System.out.println(" \thello java\n ".stripLeading());

        // 复制字符串
        System.out.println("hello world".repeat(3));

        // 统计行数
        System.out.println(" \thello java\n ".lines().count());
    }
}
