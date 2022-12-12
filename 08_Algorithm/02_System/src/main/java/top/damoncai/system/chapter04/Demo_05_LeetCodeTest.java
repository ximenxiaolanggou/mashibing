package top.damoncai.system.chapter04;

import java.util.Arrays;

public class Demo_05_LeetCodeTest {

    /**
     * leetcode测试题
     * 给定一个数组arr，两个整数lower和upper，
     * 返回arr中有多少个子数组的累加和在[lower,upper]范围上
     */
    public static void main(String[] args) {
        // 目标数组
        int[] arr = {1,-2,2,-3};

        // 生成和数组
        int[] helpArr = sumHelpArr(arr);

        // 上边界 下边界
        int upper = 1, lower = -1;

        int count = process(helpArr,0, arr.length - 1, lower,upper);
        System.out.println("出现数量为：" + count);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 和辅助数组
     * @param arr
     */
    private static int[] sumHelpArr(int[] arr) {
        int[] helpArr = new int[arr.length];
        helpArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            helpArr[i] = helpArr[i - 1] + arr[i];
        }

        return helpArr;
    }

    private static int process(int[] arr,int L, int R ,int lower, int upper) {
        // 相等时代表只有一个元素
        if(L == R) {
            // 只有一个元素，代表当前的是0~到当前数(右边界的累加和)，直接判断
            if(arr[L] >= lower && arr[L] <= upper) {
                // 在范围内返回1个
                return 1;
            }else{
                // 不在范围内返回0个
                return 0;
            }
        }

        // 存在多个元素时
        // 需要递归继续分
        int mid = L + ((R - L) >> 1);

        int leftPart = process(arr, L, mid, lower, upper);
        int rightPart = process(arr, mid + 1, R, lower, upper);

        // 归并过程
        int mergePart = merge(arr, L, mid, R, lower, upper);

        // 结果为上面三个数的和
        return leftPart + rightPart + mergePart;
    }

    /**
     * 归并逻辑
     * @param arr
     * @param L
     * @param M
     * @param R
     * @param lower
     * @param upper
     * @return
     */
    private static int merge(int[] arr, int L, int M, int R, int lower, int upper) {
        int ans = 0;
        int MIndex = M + 1;

        int windowLIndex = L, windowRIndex = L;

        while (MIndex <= R) {
            int min = arr[MIndex] - upper;
            int max = arr[MIndex] - lower;

            while (windowLIndex <= M && arr[windowLIndex] < min) // 窗口左边相等不滑动
                windowLIndex ++;

            while (windowRIndex <= M && arr[windowRIndex] <= max) // 窗口右边边相等滑动
                windowRIndex ++;

            ans += (windowRIndex - windowLIndex);

            MIndex ++;
        }


        int[] help = new int[R - L + 1];
        int helpIndex = 0;
        int leftIndex = L;
        int rightIndex = M + 1;
        while (leftIndex <= M && rightIndex <= R) {
            if(arr[leftIndex] > arr[rightIndex]) {
                help[helpIndex++] = arr[rightIndex++];
            }else{
                help[helpIndex++] = arr[leftIndex++];

            }
        }

        while (leftIndex <= M) {
            help[helpIndex++] = arr[leftIndex++];
        }

        while (rightIndex <= R) {
            help[helpIndex++] = arr[rightIndex++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

        return ans;
    }
}
