package top.damoncai.system.chapter05;

import java.util.*;

/**
 * 比较器
 */
public class Demo_01_Comparator {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 3, 2, 8, 5, 7);

        list.sort(new CustomComparator());
        System.out.println(list);
    }


     // 比较器
     static class CustomComparator implements Comparator<Integer> {

        // 返回负数： 第一个数前面数在前
        // 返回0： 都可以
        // 返回1：第二个数在前面
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 > o2 ? -1 : 1;
        }
    }
}
