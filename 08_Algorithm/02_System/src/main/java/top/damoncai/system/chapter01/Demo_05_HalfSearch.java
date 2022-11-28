package top.damoncai.system.chapter01;

import java.util.Arrays;


/**
 * 二分查找
 */
public class Demo_05_HalfSearch {

    public static void main(String[] args) {
        // 数组长度
        int len = 10;
        // 元素最大值
        int maxVal = 50;
        // 生成随机数组
        int[] arr = generateRandomArray(len, maxVal);

        // 排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));



        // 二分查找
        int targetVal = arr[3];
        int taggetIndex = halfSearch(arr, targetVal);
        System.out.println("taggetIndex：" + taggetIndex);
    }

    /**
     * 二分查找
     * @param arr
     * @param targetVal
     * @return
     */
    private static int halfSearch(int[] arr, int targetVal) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            // (left + rignt) / 2 当left和right数据很大时，相加存在越界的情况
            mid = left + ((right - left) >> 1);
            if(arr[mid] < targetVal)
                left = mid + 1;
            else if(arr[mid] > targetVal)
                right = mid - 1;
            else
               break;
        }
        return mid;
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
