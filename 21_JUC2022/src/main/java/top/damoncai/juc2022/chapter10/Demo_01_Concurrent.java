package top.damoncai.juc2022.chapter10;

import java.util.concurrent.ConcurrentHashMap;

public class Demo_01_Concurrent {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        String data = map.put("A", "A");
        System.out.println(data);

        data = map.put("A", "B");
        System.out.println(data);
    }
}
