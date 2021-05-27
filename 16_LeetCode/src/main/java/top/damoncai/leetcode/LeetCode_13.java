package top.damoncai.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     https://leetcode-cn.com/problems/roman-to-integer/
 */
public class LeetCode_13 {
    public static void main(String[] args) {
        int res = romanToInt("MCMXCIV");
        System.out.println(res);
    }


    public static int romanToInt(String s) {
        int res = 0;
        char[] templates = {'I','V','X','L','C','D','M'};
        int[] values = {1,5,10,50,100,500,1000};
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char before = chars[i];
            char after = 'N';
            if ((i + 1) < chars.length) after = chars[i + 1];
            if (before == 'I' && after == 'V') {
                res += 4;
                i++;
                continue;
            }
            if (before == 'I' && after == 'X') {
                res += 9;
                i++;
                continue;
            }
            if (before == 'X' && after == 'L') {
                res += 40;
                i++;
                continue;
            }
            if (before == 'X' && after == 'C') {
                res += 90;
                i++;
                continue;
            }
            if (before == 'C' && after == 'D') {
                res += 400;
                i++;
                continue;
            }
            if (before == 'C' && after == 'M') {
                res += 900;
                i++;
                continue;
            }

            for (int j = 0; j < templates.length; j++) {
                if (before == templates[j]) {
                    res += values[j];
                }
            }
        }
        return res;
    }
}

