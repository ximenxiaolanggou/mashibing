package top.damoncai.leetcode;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    请必须使用时间复杂度为 O(log n) 的算法。

    https://leetcode-cn.com/problems/search-insert-position/
 */
public class LeetCode_35_SearchInsert {
    public static void main(String[] args) {
       int[] nums = {1,3,5,6};
       int target = 5;
       int index = searchInsert(nums, target);
       System.out.println(index);
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if(ele >= target) {
                return i;
            }
        }
        return  nums.length;
    }
}
