package center.helloworld.algorithm.systemrevivw;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @create 2024/1/16
 * @note 归并排序实现小和问题
 */
public class Demo_16_MergeSort_SmallSum {

    public static void main(String[] args) {
        int[] arr = generateRandomArray(6, 6);
        System.out.println("原始数组：" + Arrays.toString(arr));

        int res = process(arr, 0, arr.length - 1);

        System.out.println("结果为：" + res);

        System.out.println("归并排序后数组：" + Arrays.toString(arr));

    }

    private static int process(int[] arr, int left, int right) {
        if(left == right) {
            return 0;
        }
        int mid = (left + right) >> 1;

        int leftRes = process(arr,left, mid);
        int rightRes = process(arr,mid + 1, right);
        int mergeRes = merge(arr, left, mid, right);

        return leftRes + rightRes + mergeRes;

    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int leftIndex = left;
        int rigntIndex = mid + 1;
        int helpIndex = 0;
        int res = 0;
        while (leftIndex <= mid && rigntIndex <= right) {
            res += arr[leftIndex] < arr[rigntIndex] ? (right - rigntIndex + 1) * arr[leftIndex] : 0;
            help[helpIndex ++] = arr[leftIndex] < arr[rigntIndex] ? arr[leftIndex ++] : arr[rigntIndex++];

        }
        while (leftIndex <= mid) {
            help[helpIndex ++] = arr[leftIndex ++];
        }
        while (rigntIndex <= right) {
            help[helpIndex ++] = arr[rigntIndex ++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

        return res;
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
