package top.damoncai.designattern.strategy.c_002comparator;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/1/21 17:18
 */

public class Main {

    public static void main(String[] args) {
        //
        int[] arrs = {5,4,9,8,2,4};
        Cat[] cats = {new Cat("小花",3,2),new Cat("小白",1,1),new Cat("大黑",2,3)};
        Sort<Cat> sort = new Sort<Cat>();
        sort.sort(cats,new CatWeightDescComparator());

        //可以使用lambada表达式
        sort.sort(cats,(t0,t1) -> {
            if (t0.getWeight() > t1.getWeight()) return -1;
            if (t0.getWeight() < t1.getWeight()) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(cats));
    }
}
