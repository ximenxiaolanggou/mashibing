package top.damoncai.basics.class01;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/2/27 10:18
 */

public class  Code02_BubbleSort {

    /**
     * 冒泡排序
     * 0 ~ N-1
     * 0 ~ N-2
     * 0 ~ N-3
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = {4,5,3,1,2};
        for (int i = 0 ; i < arrs.length -1 ; i++) {
            for(int j = 0 ; j < arrs.length - i - 1 ; j ++) {
                if(arrs[j] > arrs[j + 1]) swap(arrs,j,j+1);
            }
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
