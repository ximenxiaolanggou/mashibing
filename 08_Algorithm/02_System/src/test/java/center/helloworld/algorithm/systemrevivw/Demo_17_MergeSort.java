package center.helloworld.algorithm.systemrevivw;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @create 2024/1/5
 * @note 归并排序
 *
 * https://leetcode.com/problems/count-of-range-sum/
 *
 * 给定一个数组arr，两个整数lower和upper，
 *
 * 返回arr中有多少个子数组的累加和在[lower,upper]范围上
 */
public class Demo_17_MergeSort {

    public static void main(String[] args) {
        int[] arr = {2,2,-4,-4,-1};
        System.out.println("原始数组：" + Arrays.toString(arr));

        int[] preArr = new int[arr.length];
        preArr[0] = arr[0];

        for (int i = 1; i < arr.length ; i++) {
            preArr[i] = arr[i] + preArr[i - 1];
        }

        int Lower = -1;
        int Up = 1;

        System.out.println("前置数组：" + Arrays.toString(preArr));

        int count = process(preArr, 0, arr.length - 1, Lower, Up);

        System.out.println("归并排序后数组：" + Arrays.toString(arr));
        System.out.println("数量为：" + count);
    }

    private static int process(int[] preArr, int L, int R, int Lower, int Up) {
        // L == R 代表分割最小粒度，也就是一个数，此时这个数表示的是 [0, L] 这个数的和
        if(L == R) {
            if(preArr[L] >= Lower && preArr[L] <= Up) {
                return 1;
            }else {
                return 0;
            }
        }

        int M = (L + R) >> 1;

        int leftAns = process(preArr, L, M, Lower, Up);

        int rightAns = process(preArr, M + 1, R, Lower, Up);

        int mergeAns = merge(preArr, L, M,  R, Lower, Up);

        return leftAns + rightAns + mergeAns;
    }


    private static int merge(int[] arr, int L, int M, int R, int Lower, int Up) {
        //
        int ans = 0;
        int windowL = L;
        int windowR = L;
        for (int i = M + 1; i <= R ; i++) {
            int lowerNum = arr[i] - Up;
            int upNum = arr[i] - Lower;

            while (arr[windowL] < lowerNum && windowL <= M) {
                windowL ++;
            }

            while (arr[windowR] <= upNum && windowR <= M) {
                windowR ++;
            }

            ans += (windowR - windowL);
        }

        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int index = 0;
        while (p1 <= M && p2 <= R) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[index++] = arr[p1++];
        }

        while (p2 <= R) {
            help[index++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }


        return ans;
    }


    /**
     * 生成随机数组
     * @param len
     * @param maxVal
     * @return
     */
    private static int[] generateRandomArray(int len, int maxVal) {
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            // Math.random()                        [0,1)
            // Math.random() * (maxVal + 1)         [0,maxVal + 1)
            // (int) (Math.random() * (maxVal + 1)) [0,maxVal]
            arr[i] = (int) (Math.random() * (maxVal + 1)) - (int) (Math.random() * (maxVal + 1));
        }
        return arr;
    }
}
