package top.damoncai.system.chapter04;

import java.util.Arrays;

public class Demo_03_MergeByStep {


    /**
     * 不用递归
     * 使用步长来实现归并排序
     * @param args
     */
    public static void main(String[] args) {

        // 生成数组 选择排序使用
        int[] arr = generateRandomArray(10,10);

        System.out.println("初始化数组为：" + Arrays.toString(arr));

        // 归并排序
        mergeProcess(arr);

        System.out.println("归并排序后数组为：" + Arrays.toString(arr));

    }

    /**
     *
     * @param arr
     */
    private static void mergeProcess(int[] arr) {

        // 步长为 1
        int step = 1;
        int N = arr.length;

        while (step < N) {
            int L = 0;

            while (L < N) {

                int M = L + step - 1;

                if(M >= N)
                    break;

                int R = Math.min(N - 1, M + step);

                // 归并
                merge(arr, L,M, R);

                L = R + 1;
            }

            // 步长 * 2
            step <<= 1;

        }
    }

    /**
     * 归并
     * @param arr
     * @param left
     * @param right
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int helpIndex = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <=right) {
            if(arr[leftIndex] > arr[rightIndex]) {
                help[helpIndex++] = arr[rightIndex++];
            }else{
                help[helpIndex++] = arr[leftIndex++];

            }
        }

        while (leftIndex <= mid) {
            help[helpIndex++] = arr[leftIndex++];
        }

        while (rightIndex <= right) {
            help[helpIndex++] = arr[rightIndex++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
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
