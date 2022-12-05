package top.damoncai.system.chapter03;

import java.util.Arrays;

public class Demo_09_ArrRecursion {


    public static void main(String[] args) {
        int[] arr = generateRandomArray(10, 10);
        System.out.println(Arrays.toString(arr));

        // 递归获取最小值
        int min = process(arr, 0, arr.length - 1);
        System.out.println("最小值为：" + min);

    }

    /**
     * 递归获取最小值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int process(int[] arr, int left, int right) {

        if(left == right)
            return arr[left];

        int maxLeft = process(arr, left, left + ((right - left) >> 1));
        int maxRight = process(arr, left + ((right - left) >> 1) + 1, right);

        return Math.min(maxLeft, maxRight);
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
