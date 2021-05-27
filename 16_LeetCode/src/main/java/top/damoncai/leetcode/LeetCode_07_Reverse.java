package top.damoncai.leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

    如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。

    假设环境不允许存储 64 位整数（有符号或无符号）。

     https://leetcode-cn.com/problems/reverse-integer/
 */
public class LeetCode_07_Reverse {
    public static void main(String[] args) {
        int num = 1534236469;
        int reverse = reverse(num);
        System.out.println(reverse);
    }


    public static int reverse(int x) {
        //使用long 存放反转后的数据， 返回结果进行强转为int 如果有数据丢失证明越界
        long reverse = 0;
        while (x != 0) {
            int temp = x % 10;
            reverse = reverse * 10 + temp;
            x /= 10;
        }
        return (int) reverse == reverse ? (int) reverse : 0;
    }
}

