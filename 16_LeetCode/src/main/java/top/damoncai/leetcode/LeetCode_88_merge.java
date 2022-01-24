package top.damoncai.leetcode;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
   给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
 */
public class LeetCode_88_merge {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int m = 3;
        int[] num2 = {2,5,6};
        int n = 3;
        merge(num1,3,num2,3);
        System.out.println(Arrays.toString(num1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 合并数组
        for(int i = m ; i < nums1.length ; i ++) {
            nums1[i] = nums2[i - m];
        }
        // nums1 排序
        for(int i = 0 ; i < nums1.length - 1; i++) {
            for(int j = i + 1 ; j < nums1.length ; j++) {
                if(nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 合并数组
        for(int i = m ; i < nums1.length ; i ++) {
            nums1[i] = nums2[i - m];
        }
        // nums1 排序
        for(int i = 0 ; i < nums1.length - 1; i++) {
            for(int j = i + 1 ; j < nums1.length ; j++) {
                if(nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }
}
