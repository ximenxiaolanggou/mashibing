package center.helloworld.jdk.chapter_06_Jdk_14;

import org.junit.Test;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note record
 */
public class Demo_04_Record {

    @Test
    public void record() {
        var p1 = new Person("张三", 12);
        var p2 = new Person("张三", 12);
        System.out.println(p1 == p2);
    }
}

record Person(String name, Integer id) {
    // 只能定义成静态的
    static String address = "上海";
}
