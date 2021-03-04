package top.damoncai.basics.class01;

/**
 * @author zhishun.cai
 * @date 2021/2/27 11:12
 */

public class Code07_OldNumber {

    /**
     * 一个数组中有一种数出现了奇数次，其他数都出现偶数次，怎么找到并打印这种数？
     *
     * 1. 0^N == N    N^N == 0
     * 2. 异或运算满足交换律和结合律
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = {1,1,2,2,3,3,4,4,5,5,5,6,6};
        int num = 0;
        for (int arr : arrs) {
            num ^= arr;
        }
        System.out.println(num);
    }
}
