package top.damoncai.designattern.strategy.c_001comparable;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/1/21 17:18
 */

public class Main {

    public static void main(String[] args) {
        //
        int[] arrs = {5,4,9,8,2,4};
        Cat[] cats = {new Cat("小花",3),new Cat("小白",1),new Cat("大黑",2)};
        Sort sort = new Sort();
        sort.sort(cats);
        System.out.println(Arrays.toString(cats));
    }
}
