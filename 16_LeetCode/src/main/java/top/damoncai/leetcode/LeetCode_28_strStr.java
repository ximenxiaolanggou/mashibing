package top.damoncai.leetcode;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    你可以按任意顺序返回答案。

     https://leetcode-cn.com/problems/two-sum/
 */
public class LeetCode_28_strStr {
    public static void main(String[] args) {
        String haystack = "aaa";
        String needle  = "a";
        int index = strStr(haystack, needle);
        System.out.println(index);
    }

    public static int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if(needle.charAt(j) != haystack.charAt(i+j)) {
                    break;
                }
            }

            // 全部匹配(正常执行完匹配过程)
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
