package top.damoncai.basics.class01;

/**
 * @author zhishun.cai
 * @date 2021/2/27 11:47
 */

public class Code09_EvenTimesOddTimes {

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找出并打印这两种数?
     *
     * 思路：
     * 1.将所有数据异或起来，结果就是出现奇数次两个数的异或简称为reo
     * 2.获取到最右侧为1的位数，说明这两个奇数在该位置数是不同的一个为1一个为0，假设是第八位
     * 3.可以根据第八位把数组分类，最终结果，分为两类，但是这两个奇数就不在同一组中
     * 4.然后把每一组数据进行异或，两组的各自结果就是各自奇数个数的数
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = {2,2,4,4,5,5,5,6,6,7,7,8,8,8,9,9,9,9};
        //所有数据异或
        int eor = 0;
        for (int arr : arrs) {
            eor ^= arr;
        }

        //获取最右侧1
        int right = eor & ((~eor) + 1);

        //分组异或
        int first = 0,second = 0;

        for (int arr : arrs) {
            if((arr & right) == 0) {
                first ^= arr;
            }
        }
        System.out.println("first :" + first);
        System.out.println("second :" + (first ^ eor));
    }
}
