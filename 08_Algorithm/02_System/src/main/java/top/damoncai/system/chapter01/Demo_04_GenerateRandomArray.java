package top.damoncai.system.chapter01;

import java.util.Arrays;

/**
 * 生成随机数组
 */
public class Demo_04_GenerateRandomArray {

    public static void main(String[] args) {
        // 数组长度
        int len = 10;
        // 元素最大值
        int maxVal = 50;
        int[] arr = generateRandomArray(len, maxVal);
        System.out.println(Arrays.toString(arr));
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
