package center.helloworld.jdk.chapter_03_Jdk_11;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note Optional
 */
public class Demo_03_Optional {

    @Test
    public void test() {
        Optional<Integer> o1 = Optional.of(1);
        Optional<Integer> o2 = Optional.empty();

        // 1、isEmpty JDK11 判断value是否为空
        System.out.println(o1.isEmpty());
        System.out.println(o2.isEmpty());

        // 2、isPresent JDK8 判断value是否存在
        System.out.println(o1.isPresent());
        System.out.println(o2.isPresent());

        // 3、orElseThrow JDK10 返回value,如果为null则直接抛出 NoSuchElementExpception
        System.out.println(o1.orElseThrow());

        try {
            System.out.println(o2.orElseThrow());
        }catch (Exception e) {
            e.printStackTrace();
        }

        // 4、ifPresentOrElse JDK9  value非空,执行参数1功能,如果value为空,执行参数2功能
        o1.ifPresentOrElse((t) -> System.out.println("value为：" + t),() -> System.out.println("value为空"));
        o2.ifPresentOrElse((t) -> System.out.println("value为：" + t),() -> System.out.println("value为空"));

        // 5. or JDK9 value非空,返回对应的Optional,value为空,返回形参封装的Optional
        Optional<Integer> o3 = Optional.empty();
        Optional<Integer> o4 = o3.or(() -> Optional.of(3));
        System.out.println(o4.get());

        // 6、stream JDK9 value非空,返回一个仅包含此value的Steam,否则,返回一个空的Stream
        Stream<Integer> stream = o1.stream();
        stream.forEach(System.out::println);
    }
}
