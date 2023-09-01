package center.helloworld.jdk.chapter_06_Jdk_14;

import org.junit.Test;

import java.util.Date;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 文本块
 */
public class Demo_03_TextBlock {

    @Test
    public void textBlock() {
        String str1 = """
                select\
                    *
                from user
                \swhere id = 1\s
                """;
        System.out.println(str1);
    }
}
