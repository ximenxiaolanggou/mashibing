package top.damoncai.basics.class01;

/**
 * @author zhishun.cai
 * @date 2021/2/27 11:18
 */

public class Code08_LeftOneNumber {

    /**
     * 怎么把一个int类型的数，提取出最右侧的1来？
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 3  =>  ..... 00000110
         * 1  =>  ..... 00000010
         *
         * 实现：
         * 00000011  取反  11111100
         * 11111100  加1   11111101
         * 与上原来数
         * 00000011 & 11111101  => 00000001
         */
        int num = 3;

        int res = num & ((~num) + 1);
        System.out.println(res);
    }
}
