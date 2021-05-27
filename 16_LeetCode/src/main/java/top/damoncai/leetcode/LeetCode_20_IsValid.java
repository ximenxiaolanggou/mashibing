package top.damoncai.leetcode;

import java.util.*;

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
public class LeetCode_20_IsValid {
    public static void main(String[] args) {
        String s = "()[]{}";
        s = "(([]){})";
        s = "[({(())}[()])]";
        boolean res = isValid(s);
        System.out.println(res);
    }


    public static boolean isValid(String s) {

        if(null == s || s.trim().length() == 0 || s.trim().length()%2 == 1) return false;

        List<Character> chars = Arrays.asList('{','[','(',')',']','}');

        boolean res = true;
        while (s.length() > 0) {
            // 1.获取第一个左右括号转折点
            int tp = -1;
            for (int i = 0; i < s.length() - 1; i++) {
                char bc = s.charAt(i);
                char ac = s.charAt(i + 1);
                if(chars.indexOf(bc) < chars.indexOf(ac) && chars.indexOf(bc) + chars.indexOf(ac) == 5) {
                    tp = i;
                    break;
                };
            }

            if(tp == -1) {
                res = false;
                break;
            }

            //从内往外去除
            while (tp >= 0 && tp != s.length() -1 ) {
                char bc = s.charAt(tp);
                char ac = s.charAt(tp + 1);
                if(chars.indexOf(bc) + chars.indexOf(ac) == 5) {
                    s = s.substring(0,tp) + s.substring(tp + 2);
                    tp--;
                    continue;
                }
                break;
            }
        }
        return res;
    }
}

