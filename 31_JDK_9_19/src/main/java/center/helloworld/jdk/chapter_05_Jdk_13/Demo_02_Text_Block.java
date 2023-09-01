package center.helloworld.jdk.chapter_05_Jdk_13;

import org.junit.Test;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 文本块
 */
public class Demo_02_Text_Block {

    @Test
    public void textBlock() {
        String str1 = """
                select 
                    * 
                from user
                wher id = 1
                """;
        System.out.println(str1);
    }
}
