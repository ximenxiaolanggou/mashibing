package center.helloworld.algorithm.systemrevivw;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @create 2024/1/3
 * @note 递归求最大值
 */
public class Demo_13_Recursion {

    public static void main(String[] args) {
        int[] arr = generateRandomArray(2, 10);
        System.out.println(Arrays.toString(arr));
        int target = process(arr, 0, arr.length - 1);
        System.out.println("最大值为：" + target);
    }


    public static int process(int[] arr, int start, int end) {
        if(start > end) {
            return -1;
        }

        if(start == end) {
            return arr[start];
        }


        int mid = (start + end) >> 2;

        int left = process(arr,start, mid);
        int right = process(arr,mid + 1, end);
        return Math.max(left, right);
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
