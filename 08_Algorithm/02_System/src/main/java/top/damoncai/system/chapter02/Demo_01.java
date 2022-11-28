package top.damoncai.system.chapter02;


public class Demo_01 {

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3,3,3,4,4,4,4,5,5,5,5,5,6,6,6,6,6,6};

        // 得到两个奇数异或值
        int eor = 0;
        for (int element : arr) {
            eor ^= element;
        }

        // eor的值为这两个奇数的异值

        // 找出最右侧为1的值，因为最右侧为1的数，代表这两个奇数在此位上是不同的

        int bitV = eor & (~eor + 1);

        // 根据这个位上为1或者不唯一进行分类，将这两个奇数分开

        // 第一个奇数
        int oneV = 0;
        for (int element : arr) {
            // 该位置上为0的都异或上
            if((element & bitV) == 0) {
                oneV ^= element;
            }
        }
        System.out.println("第一个奇数：" + oneV);
        System.out.println("第二个奇数：" + (eor ^ oneV));
    }
}
