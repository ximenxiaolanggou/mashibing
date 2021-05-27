package top.damoncai.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
public class LeetCode_20_IsValid4 {
    public static void main(String[] args) {
        String s = "()[]{}";
        s = "(([]){})";
        s = "[({(())}[()])]";
        boolean res = isValid(s);
        System.out.println(res);
    }


    public static boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (char charTemp : s.toCharArray()) {
            if('{' == charTemp) list.addLast('}');
            else if('[' == charTemp) list.addLast(']');
            else if('(' == charTemp) list.addLast(')');
            else if(list.isEmpty() || list.removeLast() != charTemp) {
                return false;
            }
        }
        return list.isEmpty();
    }

}

