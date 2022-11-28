package top.damoncai.system.chapter01;

import java.util.Arrays;

/**
 * 选择排序案例
 */
public class Demo_01_SelectSort {

    public static void main(String[] args) {
        int[] arr = {3,5,2,9,6,7};

        // 3,5,2,9,6,7
        // 2,3,5,9,6,7 内存第一次循环结束
        // 2,3,5,9,6,7 内存第二次循环结束
        //.......

        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr
     */
    private static void selectSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 这里也可以不用记录需要交换的索引，直接交换值(考虑到可能平凡交换这里就记录后面最大值的索引)
                if(arr[minIndex] > arr[j]) minIndex = j;
            }
            // 不相等，说明存在更小的值
            if(i != minIndex) swap(arr, i, minIndex);
        }
    }

    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
