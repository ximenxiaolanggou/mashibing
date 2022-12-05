package top.damoncai.system.chapter04;


import java.util.Arrays;

public class Demo_02_MergeByRecursion_TestTime {

    /**
     * 通过递归实现归并排序
     * 测试时间
     * 因为选择排序时间复杂度为 O(N^2), 归并排序为O(N * logN),这里主要目的就是测试一下时间
     */
    public static void main(String[] args) {

        // 测试次数
        int testTimes = 1;
        for (int i = 0; i < testTimes; i++) {
            // 生成数组 选择排序使用
            int[] arrSelect = generateRandomArray(100000,10000);
            // 拷贝数组 归并排序使用
            int[] arrMerge = new int[arrSelect.length];
            System.arraycopy(arrSelect, 0,arrMerge, 0,arrSelect.length);
//            System.out.println("初始数组：" + Arrays.toString(arrSelect));

            long stamp1 = System.currentTimeMillis();
            System.out.println("选择排序开始：" + stamp1);
            selectSort(arrSelect);
            long stamp2= System.currentTimeMillis();
            System.out.println("选择排序结束，花费：" + (stamp2 - stamp1));

            System.out.println("归并排序开始：" + stamp2);
            process(arrMerge,0, arrMerge.length - 1);
            long stamp3= System.currentTimeMillis();

            System.out.println("归并排序结束，花费：：" + (stamp3 - stamp2));

            // 对数器比较
            compareRes(arrMerge, arrSelect);
            System.out.println("结果正确");
        }


    }

    /**
     * 结果比较
     * @param arrMerge
     * @param arrSelect
     */
    private static void compareRes(int[] arrMerge, int[] arrSelect) {
        for (int i = 0; i < arrMerge.length; i++) {
            if(arrMerge[i] != arrSelect[i]) {
                System.out.println("出错啦~~~~");
                return;
            }
        }
    }

    /**
     * 处理程序
     * @param arr
     * @param left
     * @param right
     */
    private static void process(int[] arr, int left, int right) {
        // 剩余一个数
        if(left == right)
            return ;

        int mid = left + ((right - left) >> 1);
        process(arr ,left, mid);
        process(arr ,mid + 1, right);

        // 归并
        merge(arr, left,mid, right);

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


    /**
     * 选择排序
     * @param arr
     */
    private static void selectSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 这里也可以不用记录需要交换的索引，直接交换值(考虑到可能平凡交换这里就记录后面最大值的索引)
                if(arr[minIndex] > arr[j]) minIndex = j;
            }
            // 不相等，说明存在更小的值
            if(i != minIndex) swap(arr, i, minIndex);
        }
    }

    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
