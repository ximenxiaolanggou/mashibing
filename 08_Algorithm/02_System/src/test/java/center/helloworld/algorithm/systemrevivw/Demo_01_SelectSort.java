package center.helloworld.algorithm.systemrevivw;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @create 2023/10/26
 * @note 选择排序
 */
public class Demo_01_SelectSort {

    public static void main(String[] args) {

        int[] arr = {3,8,5,1,6,0};
        print("排序前：", arr);
        sort(arr);
        print("排序后：", arr);
        sort2(arr);
        print("排序后：", arr);
    }

    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    swap(i, j ,arr);
                }
            }
        }
    }

    public static void sort2(int[] arr) {
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) { // 记录索引，避免频繁调用swap
                    minIndex = j;
                }
            }
            if(i != minIndex) swap(i, minIndex, arr);
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
