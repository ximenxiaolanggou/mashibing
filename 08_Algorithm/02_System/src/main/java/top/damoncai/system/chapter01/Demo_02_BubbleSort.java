package top.damoncai.system.chapter01;

import java.util.Arrays;

/**
 * 冒泡排序案例
 */
public class Demo_02_BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,5,2,9,6,7};

        // 3,5,2,9,6,7
        // 3,2,5,6,7,9 内存第一次循环结束
        // 2,3,5,6,7,9 内存第二次循环结束
        //.......

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序排序
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        // 外层控制循环次数
        for(int i = 1 ; i < arr.length ; i++) {
            // 内层相邻值比较
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
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
