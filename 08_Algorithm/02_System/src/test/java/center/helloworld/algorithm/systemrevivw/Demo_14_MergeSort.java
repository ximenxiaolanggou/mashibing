package center.helloworld.algorithm.systemrevivw;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @create 2024/1/5
 * @note 归并排序 - 递归版本
 */
public class Demo_14_MergeSort {

    public static void main(String[] args) {
        int[] arr = generateRandomArray(10, 10);
        System.out.println("原始数组：" + Arrays.toString(arr));

        process(arr, 0, arr.length - 1);

        System.out.println("归并排序后数组：" + Arrays.toString(arr));
    }

    private static void process(int[] arr, int left, int right) {
        if(left == right) return;

        int mid = ((left + right) >> 1);

        process(arr, left, mid);
        process(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }


    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= right) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }

        while (p2 <= right) {
            help[index++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
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
