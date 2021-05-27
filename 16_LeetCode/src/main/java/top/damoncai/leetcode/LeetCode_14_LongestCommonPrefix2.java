package top.damoncai.leetcode;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     https://leetcode-cn.com/problems/roman-to-integer/
 */
public class LeetCode_14_LongestCommonPrefix2 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }

    
    public static String longestCommonPrefix(String[] strs) {
       String res = strs[0];
        for (String str : strs) {
            while (!str.startsWith(res)) {
                res = res.substring(0,res.length() -1);
            }
        }
        return res;
    }
}

