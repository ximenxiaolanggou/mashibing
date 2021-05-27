package top.damoncai.leetcode;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

     https://leetcode-cn.com/problems/palindrome-number/
 */
public class LeetCode_09_IsPalindrome {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println(palindrome);
    }


    public static boolean isPalindrome(int x) {
        if(x < 0) return  false;
        int copyX = x;
        int palindrome = 0;
        while (x != 0) {
            palindrome = palindrome * 10 + x % 10;
            x = x / 10;
        }
        return copyX == palindrome;
    }
}

