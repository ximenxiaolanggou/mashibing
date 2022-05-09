package top.damoncai.leetcode;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

https://leetcode-cn.com/problems/add-binary/


    setp one: 长度补全
                1. 开始补全
                2. 边算边补

 */
public class LeetCode_67_AddBinary2 {
    public static void main(String[] args) {
      String a = "1010", b = "1011";
      String res = addBinary(a,b);
      System.out.println(res);
    }

    public static String addBinary(String a, String b) {
        int sum = 0;
        StringBuffer sb = new StringBuffer("");
        for (int i = a.length() - 1,j = b.length() - 1; i >= 0 || j >= 0 ; i--,j--) {
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb = sb.insert(0,sum % 2 + "");
            sum = sum / 2;
        }
        return sum == 1 ? 1 + sb.toString() : sb.toString();
    }
}
