package top.damoncai.leetcode;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class LeetCode_69_Solution {
    public static void main(String[] args) {
      int res = mySqrt(2147483647);
      System.out.println(res);
    }

    public static int mySqrt(int x) {
        if( x == 0) return 0;
       int res = 1;
        for(int i = 1 ; i < x; i++) {
            if(Long.valueOf(i) * Long.valueOf(i) == Long.valueOf(x)){
                res = i;
                break;
            }
            if(Long.valueOf(i) * Long.valueOf(i) > Long.valueOf(x)){
                res = i -1;
                break;
            }
        }
        return res;
    }
}
