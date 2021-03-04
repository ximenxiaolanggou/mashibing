package top.damoncai.basics.class01;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/2/27 10:00
 */

public class Code01_SelectionSort {


    /**
     * 选择排序
     * 4 1 3
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] arrs = generateRandomArray(10,100);
        for (int i = 0 ; i < arrs.length -1 ; i++) {
            int minIndex = i;
            for(int j = i + 1 ; j < arrs.length ; j ++) {
                if(arrs[minIndex] > arrs[j]) minIndex = j;
            }
            swap(arrs,i,minIndex);
        }
        System.out.println(Arrays.toString(arrs));
    }

    private static void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
