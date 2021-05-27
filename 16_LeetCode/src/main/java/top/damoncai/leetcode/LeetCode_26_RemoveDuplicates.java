package top.damoncai.leetcode;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
     给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。


说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

    // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
    int len = removeDuplicates(nums);

    // 在函数里修改输入数组对于调用者是可见的。
    // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
    for (int i = 0; i < len; i++) {
        print(nums[i]);
    }

     https://leetcode-cn.com/problems/two-sum/
 */
public class LeetCode_26_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int index = 0;
        //控制需要循环的次数
        for(int i = 0 ; i < nums.length - 1 - index; i++) {
            //内层循环比较
            int template = nums[i];
            int toCompare = nums[i + 1];
            while ((template = nums[i]) == (toCompare = nums[i + 1]) && i < nums.length - index - 1) {
                //放到最后并向前移懂
                if(i == nums.length - 2) {
                    index ++;
                    break;
                }
                for (int k = i + 1; k < nums.length - 1; k++) {
                    nums[k] = nums[k + 1];
                }
                nums[nums.length - 1] = toCompare;
                index++;
            }
        }
        return nums.length - index;
    }
}
