package top.damoncai.system.chapter04;


import java.util.Arrays;

/**
 * 给定一个数组arr，和一个整数num。请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。
 *
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class Demo_05_PartitionAndQuickSort {

    public static void main(String[] args) {

        int[] arr = generateRandomArray(5, 10);
        int target = arr[2];

        System.out.println("原始数组：" + Arrays.toString(arr) + "目标数为：" + target);

        partition(arr, target);

        System.out.println("结果数组：" + Arrays.toString(arr));


    }

    /**
     * 逻辑
     * @param arr
     */
    private static void partition(int[] arr, int T) {
        int L = -1;
        int R = arr.length;
        int C = 0;
        while (C < R) {
            if(arr[C] < T) {
                swap(arr, L + 1, C);
                L++;
            }
            C++;
        }
    }

    /**
     * 索引交换数据
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
