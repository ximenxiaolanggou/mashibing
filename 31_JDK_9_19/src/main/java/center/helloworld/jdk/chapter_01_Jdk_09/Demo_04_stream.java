package center.helloworld.jdk.chapter_01_Jdk_09;

import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note takeWhile,dropWhile,ofNullable
 */
public class Demo_04_stream {

    /**
     * 测试Stream新增takeWhile方法
     * takeWhile  从流中的头开始取元素,直到不满足条件为止
     */
    @Test
    public void takeWhile() {
        Stream<Integer> stream = Stream.of(0, 2, 4, 6, 8, 10, 12);
        stream.takeWhile(e -> e  < 10).forEach(System.out::println);
    }

    /**
     * dropWhile  从头开始删除满足条件的数据,直到遇见第一个不满足的位置,并保留剩余元素
     */
    @Test
    public void dropWhile() {
        Stream<Integer> stream = Stream.of(0, 2, 4, 6, 8, 10, 12);
        stream.dropWhile(e -> e  < 10).forEach(System.out::println);
    }

    /**
     * ofNullable 允许创建Stream流时,只放入一个null
     */
    @Test
    public void ofNullable() {
        // of方法获取流 ,允许元素中有多个null值
        Stream<Integer> stream1 = Stream.of(10, 20, 30, null);
        // 如果元素中只有一个null,是不允许的
        Stream<Integer> stream2 = Stream.of(null);
        // JAVA9中,如果元素为null,返回的是一个空Stream,如果不为null,返回一个只有一个元素的Stream
        Stream<Integer> stream3 = Stream.ofNullable(null);
    }

    /**
     * iterate指定种子数，指定条件和迭代方式来获取流
     */
    @Test
    public void testNewIterate() {
        // java8中 generate方法获取流
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        // java8中 iterate方法获取流
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        // java9中 添加iterate重载方法获取流, 这里表示获取10个，但是当Predicate返回false后就不会再执行了，下面就是获取一个元素
        Stream.iterate(0,t -> t % 3 == 0, t -> t + 2).limit(10).forEach(System.out::println);
    }


    /**
     * Optional类新增Stream方法,可以将一个Optional转换为Stream
     */
    @Test
    public static void testOptionalStream(){
        List<Integer> list =new ArrayList<>();
        Collections.addAll(list,10,5,45,95,36,85,47);
        Optional<List<Integer>> optional=Optional.ofNullable(list);

        // 通过optional的Stream方法获取一个Stream
        Stream<List<Integer>> stream = optional.stream();
        // 以为内部的每个元素也是一个List,通过flatMap方法,将内部的List转换为Stream后再放入一个大Stream
        stream.flatMap(x->x.stream()).forEach(System.out::println);

    }


}
