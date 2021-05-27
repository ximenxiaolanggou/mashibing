package top.damoncai.leetcode;

import java.util.Arrays;
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
public class LeetCode_20_IsValid3 {
    public static void main(String[] args) {
        String s = "()[]{}";
        s = "(([]){})";
        s = "[({(())}[()])]";
        boolean res = isValid(s);
        System.out.println(res);
    }


    public static boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }

}

