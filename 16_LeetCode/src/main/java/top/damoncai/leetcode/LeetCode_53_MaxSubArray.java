package top.damoncai.leetcode;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    https://leetcode-cn.com/problems/maximum-subarray/
 */
public class LeetCode_53_MaxSubArray {
    public static void main(String[] args) {
       int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
       int max = maxSubArray(nums);
       System.out.println(max);
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];

        /**
         *      1 2 3 4
         *        2 3 4
         *          3 4
         *            4
         */

        // 循环次数 和 i为循环其实位置
        for (int i = 0; i < nums.length; i++) {

            /**
             *      1 2 3 4 为例
             *
             *      1       求和
             *      1 2     求和
             *      1 2 3   求和
             *      1 2 3 4 求和
             */
            for (int j = i; j < nums.length; j++) {
                int totalItem = 0;
                for (int k = i; k <= j; k++) {
                    totalItem += nums[k];
                }
                if(max < totalItem) {
                    max = totalItem;
                }
            }
        }
        return max;
    }
}
