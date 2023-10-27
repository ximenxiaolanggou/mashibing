package center.helloworld.algorithm.systemrevivw;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @create 2023/10/26
 * @note 插入排序
 */
public class Demo_03_BubblingSort {

    public static void main(String[] args) {

        int[] arr = {3,8,5,1,6,0};
        print("排序前：", arr);
        sort(arr);
        print("排序后：", arr);
    }

    /**
     * 3 8 5 1 6 0
     *
     * 3 8
     * 3 5 8
     * 1 3 5 8
     * 1 3 5 6 8
     * 0 1 3 5 6 8
     * 这里需要注意的是，没插入一个数需要从后往前面找
     * 外层控制插入数的索引位置，内层用来比较和交换
     * @param arr
     */
    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
               if(arr[j] < arr[j-1]) {
                   swap(j, j-1, arr);
               }else {
                   break; // 如果不大于说明前面是不存在大于需要插入的数，本次插入结束
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
