package top.damoncai.leetcode;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     https://leetcode-cn.com/problems/roman-to-integer/
 */
public class LeetCode_14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }


    public static String longestCommonPrefix(String[] strs) {
        //获取最短字符
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            if(strs[index].length() > strs[i].length()) index = i;
        }
        StringBuffer sb = new StringBuffer("");

        for (int i = 0; i < strs[index].length(); i++) {
            char template =  strs[index].charAt(i);
            boolean stop = false;
            for (String str : strs) {
                if(str.charAt(i) != template) {
                    stop = true;
                    break;
                }
            }
            if(stop) break;
            sb.append(template);
        }

        return sb.toString();
    }
}

