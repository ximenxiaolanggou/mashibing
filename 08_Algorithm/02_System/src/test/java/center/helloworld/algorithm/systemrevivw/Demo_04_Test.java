package center.helloworld.algorithm.systemrevivw;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @create 2023/10/26
 * @note 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
 */
public class Demo_04_Test {

    public static void main(String[] args) {

        int[] arr = {2,2,3,3,4,5,5,6,6,6,6,7,7,7,8,8};

        // 最终mid 为出现奇数次的两个数的异或
        int mid = 0;

        for (int num : arr) {
            mid ^= num;
        }

        // 由于这两个数不同，mid不可能为0，由于异或不同为1，找出最右侧为1数
        int rightOne = ((~mid) + 1) & mid;

        // 然后按照这位数上是佛为1分为两组，并且这两组各种组内异或最后各位这两个出现奇数次的数
        int first = 0;

        for (int num : arr) {
            if((num & rightOne) == 0)
                first ^= num;
        }

        System.out.println("第一个数为：" + first);
        System.out.println("第二个数为：" + (first ^ mid));

    }


}
