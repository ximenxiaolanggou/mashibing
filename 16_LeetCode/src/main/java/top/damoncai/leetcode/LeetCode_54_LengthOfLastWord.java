package top.damoncai.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
   给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。

    单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

    https://leetcode-cn.com/problems/length-of-last-word/
 */
public class LeetCode_54_LengthOfLastWord {
    public static void main(String[] args) {
       String name = "   fly me   to   the moon  ";
       int max = lengthOfLastWord(name);
       System.out.println(max);
    }

    public static int lengthOfLastWord(String s) {
//        int len = 0;
//        String reg = "^\\w+$";
//        String[] words = s.split("\\s+");
//        for (String word : words) {
//            Pattern
//            boolean matches = Pattern.matches(reg, word);
//            if(matches) len = word.length();
//        }
//        return len;
        s = s.trim();
        String[] words = s.split("\\s+");
        return words[words.length - 1].length();
    }
}
