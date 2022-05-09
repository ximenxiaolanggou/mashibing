package top.damoncai.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.reverse;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

    你可以假设除了整数 0 之外，这个整数不会以零开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class LeetCode_66_Solution {
    public static void main(String[] args) {
      int[] digits = {9,8,7,6,5,4,3,2,9,9};
      digits = plusOne(digits);
      System.out.println(Arrays.toString(digits));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; 0 <= i; i--) {
            if(digits[i] != 9){
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
