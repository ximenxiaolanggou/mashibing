package top.damoncai.system.chapter04;

public class Demo_04_SmallSumProblem {


    /**
     * 小和问题
     *
     * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
     * 例子： [1,3,4,2,5]
     * 1左边比1小的数：没有
     * 3左边比3小的数：1
     * 4左边比4小的数：1、3
     * 2左边比2小的数：1
     * 5左边比5小的数：1、3、4、 2
     * 所以数组的小和为1+1+3+1+1+3+4+2=16
     */
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,4,6};


        int sum = process(arr, 0, arr.length - 1);

        System.out.println(sum);

    }

    private static int process(int[] arr, int left, int right) {
        if(left == right) return 0;

        int midIndex = left + ((right - left) >> 1);
        int leftVal = process(arr, left, midIndex);
        int rightVal = process(arr,midIndex + 1, right);
        int mergeVal = merge(arr, left, midIndex, right);

        return leftVal + rightVal + mergeVal;

    }

    /**
     * merge
     * @param arr
     * @param left
     * @param midIndex
     * @param right
     */
    private static int merge(int[] arr, int left, int midIndex, int right) {
        int pos1 = left;
        int pos2 = midIndex + 1;
        int[] help = new int[right - left + 1];
        int helpIndex = 0;
        int sum = 0;
        while (pos1 <= midIndex && pos2 <= right) {
            // 左边组小于右组才拷贝左组数
            if(arr[pos1] < arr[pos2]) {
                sum += arr[pos1] * (right - pos2 + 1);
                help[helpIndex++] = arr[pos1 ++];
            }else{
                help[helpIndex++] = arr[pos2++];
            }
        }

        while (pos1 <= midIndex) {
            help[helpIndex++] = arr[pos1++];
        }

        while (pos2 <= right) {
            help[helpIndex++] = arr[pos2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

        return sum;
    }
}
