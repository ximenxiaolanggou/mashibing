package top.damoncai.leetcode;

import java.util.LinkedList;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。

     https://leetcode-cn.com/problems/valid-parentheses/
 */
public class LeetCode_1190_ReverseParentheses {
    public static void main(String[] args) {
        String s = "ta()usw((((a))))";
        String res = reverseParentheses(s);
        System.out.println(res);
    }


    public static String reverseParentheses(String s) {
        int perfixIndex = -1;
        int suffixIndex = -1;
        while (true) {
            perfixIndex = s.lastIndexOf("(");
            suffixIndex = s.indexOf(")",perfixIndex);
            if(perfixIndex < 0 || perfixIndex < 0) {
                break;
            }
            String prefix = s.substring(0,perfixIndex);
            String mid = s.substring(perfixIndex + 1,suffixIndex);
            String suffix = s.substring(suffixIndex + 1);
            if(mid == null || mid.trim() == "") {
                s = prefix + suffix;
                continue;
            }
            char[] chars = mid.toCharArray();
            for (int i = 0,j = mid.length() - 1; i < j; i++,j--) {
                char tempChar = chars[i];
                chars[i] = chars[j];
                chars[j] = tempChar;
            }
            mid = new String(chars);
            s = prefix + mid + suffix;
        }
        return s;
    }
}

