package top.damoncai.system.chapter03;

import java.util.HashMap;

public class Demo_10_HashMap {

    public static void main(String[] args) {
        Integer num1 = new Integer(2);
        Integer num2 = new Integer(2);

        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));

        HashMap<Integer, Integer> map = new HashMap<>();
        // 基本数据类型的包装类存放到hashmap中会拆包存放，以值传递
        map.put(num1, 1);
        System.out.println(map.containsKey(num2));
    }
}
