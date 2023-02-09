package top.damoncai.system.chapter04;


import java.util.Arrays;

/**
 * 荷兰国旗问题 升级版本
 *
 * 给定一个数组arr，和一个整数num，这个整为arr数组最后一个位数（arr[arr.length - 1]）。请把小于num的数放在数组的左边，等于num的数放在中间，大于num的数放在数组的右边。
 *
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class Demo_07_NetherlandsFlagProblemUpgrade {

    public static void main(String[] args) {

        int[] arr = generateRandomArray(10, 10);
        int target = arr[arr.length - 1];

        System.out.println("原始数组：" + Arrays.toString(arr) + "目标数为：" + target);

        int[] pArr = partition(arr);

        System.out.println("结果数组：" + Arrays.toString(arr));

        System.out.println("下标范围为：" + Arrays.toString(pArr));


    }

    /**
     * 逻辑
     * @param arr
     */
    private static int[] partition(int[] arr) {
        int T = arr[arr.length - 1];
        int L = -1;
        int R = arr.length - 1;
        int C = 0;
        while (C < R) {
            if(arr[C] == T)
                C++;

            else if(arr[C] < T) {
                swap(arr, L + 1, C);
                L++;
                C++;

            }

            // 当前数和右边界交换后，当前数不能++,应为交换过来的数没有瞅过
            else if(arr[C] > T) {
                swap(arr, R  - 1, C);
                R--;

            }
        }
//        // 判断L 和 R是否紧挨着， 如果是代表中间不存在num数
//        if((L + 1) == R) {
//            // L 和 R紧挨着， 不存在中间num数，R和数组最后一个数交换
//            swap(arr ,R, arr.length - 1);
//        }else {
//            // L 和 R不紧挨着， 存在中间num数，R前面一个数和数组最后一个数交换
//            swap(arr ,R - 1, arr.length - 1);
//        }

        // 上面的一顿分析可以最终写成 ， R 和 数组最后一个数交换，无需关心L和R中间是否夹着num数，哪怕是存在R和arr.length - 1 的数交换玩后 R位子数>= R-1位置数
        swap(arr ,R, arr.length - 1);

        return new int[]{L + 1, R};
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
