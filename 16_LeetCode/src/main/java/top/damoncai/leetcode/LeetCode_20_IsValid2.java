package top.damoncai.leetcode;

import java.util.Arrays;
import java.util.List;

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
public class LeetCode_20_IsValid2 {
    public static void main(String[] args) {
        String s = "()[]{}";
        s = "(([]){})";
        s = "[({(())}[()])]";
        s = "()[]{}";
        s = "(]";
        s = "[[[]";
        s = "(){}}{";
        boolean res = isValid(s);
        System.out.println(res);
    }


    public static boolean isValid(String s) {

        if(null == s || s.trim().length() == 0 || s.trim().length()%2 == 1) return false;

        List<Character> chars = Arrays.asList('{','[','(',')',']','}');

        int orgLen = s.length();
        while (true) {
            s = s.replace("{}","").replace("[]","").replace("()","");
            if(orgLen != s.length()) {
                orgLen = s.length();
                continue;
            };
            break;
        }
        return s == "";
    }
}

