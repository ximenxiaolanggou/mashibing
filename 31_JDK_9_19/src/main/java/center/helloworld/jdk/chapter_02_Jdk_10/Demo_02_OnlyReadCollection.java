package center.helloworld.jdk.chapter_02_Jdk_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 只读集合
 */
public class Demo_02_OnlyReadCollection {

    @Test
    public void test() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.copyOf(list1);
        System.out.println(list1 == list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = List.copyOf(list3);
        System.out.println(list3 == list4);
    }

}
