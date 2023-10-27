package center.helloworld.algorithm.systemrevivw;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @create 2023/10/26
 * @note 冒泡排序
 */
public class Demo_02_BubblingSort {

    public static void main(String[] args) {

        int[] arr = {3,8,5,1,6,0};
        print("排序前：", arr);
        sort(arr);
        print("排序后：", arr);
    }

    /**
     * 3 8 5 1 6 0
     * 第一轮
     *   3 8 5 1 6 0
     *   3 5 8 1 6 0
     *   3 5 1 8 6 0
     *   3 5 1 6 8 0
     *   3 5 1 6 0 8
     * @param arr
     */
    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    /**
     * @param i
     * @param j
     * @param arr
     */
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印
     * @param prefix
     * @param arr
     */
    public static void print(String prefix, int arr[]) {
        System.out.println((StringUtils.isNotBlank(prefix) ? prefix : "") + Arrays.toString(arr));
    }
}
