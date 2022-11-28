package top.damoncai.system.chapter01;

import java.util.Arrays;

/**
 * 插入排序案例
 */
public class Demo_03_InsertSort {

    public static void main(String[] args) {
        int[] arr = {3,5,2,9,6,7};

        // 3,5,2,9,6,7
        // 3,5,2,9,6,7
        // 2,3,5,9,6,7
        // ...

        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param arr
     */
    private static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        // 3,5
        // 3,5,2 => 2,3,5

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; (j - 1) >= 0; j--) {
                if(arr[j] < arr[j - 1]) swap(arr,j , j - 1);
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
