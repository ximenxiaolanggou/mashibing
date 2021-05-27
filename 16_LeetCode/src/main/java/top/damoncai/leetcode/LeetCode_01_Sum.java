package top.damoncai.leetcode;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    你可以按任意顺序返回答案。

     https://leetcode-cn.com/problems/two-sum/
 */
public class LeetCode_01_Sum {
    public static void main(String[] args) {
        int[] nums = {};
        int target = 2;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length == 2) return new int[]{0,1};
        int[] resArr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = (i + 1); j < nums.length; j++) {
                if((nums[i] + nums[j]) == target) {
                    resArr[0] = i;
                    resArr[1] = j;
                    return resArr;
                }
            }
        }
        return resArr;
    }
}
