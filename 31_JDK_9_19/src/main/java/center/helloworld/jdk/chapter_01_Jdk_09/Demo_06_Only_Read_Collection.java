package center.helloworld.jdk.chapter_01_Jdk_09;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 只读集合
 */
public class Demo_06_Only_Read_Collection {

    /**
     * Java 8 中创建只读集合
     */
    @Test
    public void onlyReadCollectionJava8() {
        // 方式一
        List<Integer> list = Arrays.asList(1, 2, 3);

        // 方式二
        Collections.unmodifiableList(Arrays.asList());

    }

    /**
     * Java 9 中创建只读集合
     */
    @Test
    public void onlyReadCollectionJava9() {
        List<Integer> list = List.of(1, 2, 3);
        Set<Integer> set = Set.of(1, 2, 3);
        Map<String, ? extends Serializable> map = Map.of("name", "张三", "age", 12);
    }

}
