package top.damoncai.distributelok.zk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhishun.cai
 * @create 2023/2/20
 * @note
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> eles = Arrays.asList(1, 2, 3, 4, 5);
        eles.stream().skip(2).limit(2).collect(Collectors.toList()).stream().forEach(System.out::println);

    }
}
