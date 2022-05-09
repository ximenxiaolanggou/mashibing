package top.damoncai.leetcode;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

https://leetcode-cn.com/problems/add-binary/

 */
public class LeetCode_67_AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
      String res = addBinary(a,b);
      System.out.println(res);
    }

    public static String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int sbuLen = aLen - bLen;
        StringBuffer  sb = new StringBuffer("");
        for (int i = 0; i < Math.abs(sbuLen); i++) {
            sb.append("0");
        }
        if(sbuLen > 0) {
            b = sb.toString() + b;
        }else if(sbuLen < 0) {
            a = sb.toString() + a;
        }
        String res = "";
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        boolean stepOne = false;
        for (int i = aChars.length - 1; i >= 0 ; i--) {
            if(aChars[i] == '1' && bChars[i] == '1') {
                if(stepOne) {
                    res = 1 + res;
                }else{
                    res = 0 + res;
                }
                stepOne = true;
            }else if(aChars[i] == '1' || bChars[i] == '1') {
                if(stepOne) {
                    res = 0 + res;
                }else{
                    res = 1 + res;
                    stepOne = false;
                }
            }else{
                if(stepOne) {
                    res = 1 + res;
                }else{
                    res = 0 + res;
                }
                stepOne = false;
            }
        }
        if(stepOne) {
            res = 1 + res;
        }
        return res;
    }
}
