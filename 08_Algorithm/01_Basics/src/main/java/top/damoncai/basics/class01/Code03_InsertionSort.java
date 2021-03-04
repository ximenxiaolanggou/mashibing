package top.damoncai.basics.class01;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2021/2/27 10:38
 */

public class Code03_InsertionSort {

    /**
     * 插入排序
     * 4,5,3,1,2
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = {4,5,3,1,2};
        for (int i = 1 ; i < arrs.length ; i++) {
            int minIndex = i;
            for(int j = 0 ; j < i ; j ++) {
                if(arrs[j] > arrs[i]) swap(arrs,i,j);;
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
