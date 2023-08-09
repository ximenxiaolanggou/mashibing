package center.helloworld.jdk.chapter_02_Jdk_10;

import center.helloworld.jdk.entity.Person;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 局部变量类型推断
 */
public class Demo_01_var {

    @Test
    public void test() {
        var name = "张飒";
        System.out.println(name.length());

        var person = new Person();
        person.eat();

        var arrayList =new ArrayList<String>();
        arrayList.stream().forEach(System.out::println);

        for (var el : arrayList) {
            System.out.println(el);

        }
    }

}
