package center.hellowrold.jvm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/4/19
 * @note
 */
public class Test {

    public static void main(String[] args) {

       List<Integer> list = new ArrayList<>();
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);

        List<Integer> integers = list.subList(0, 3);
        System.out.println(integers);
    }


    private static void getPiRulesDeep(int deep,int[] arr, List<PiRule> piRules) {
        for (PiRule piRule : piRules) {
            deep ++;
            List<PiRule> childPiRules = piRule.getChildren();
            if(childPiRules != null && childPiRules.size() > 0) {
                getPiRulesDeep(deep,arr, childPiRules);
            }
            if(arr[0] < deep) arr[0] = deep;

        }
    }
}
