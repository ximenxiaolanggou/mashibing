package top.damoncai.basics.class01;

public class Code01_bit_operation {

    /**
     * 位运算
     */
    public static void main(String[] args) {

        System.out.println(1024 << 1); // 相当于乘 2
        System.out.println();
        bitOperation(3);
        System.out.println("========");
        bitOperation(-3);
        System.out.println("========");
        int num = 5;
        bitOperation(num);
        bitOperation(-num);
        bitOperation(~num);
        bitOperation( ~ num + 1);

        System.out.println("========");
        bitOperation(3);
        bitOperation(3 >> 1);
        bitOperation(3 >>> 1);

        System.out.println("========");
        bitOperation(-3);
        bitOperation(-3 >> 1); // 右移运算符
        bitOperation(-3 >>> 1); //  无符号右移
    }

    /**
     * 输出32为二进制数
     * @param num
     */
    private static void bitOperation(int num) {
        for (int i = 31; i >= 0  ; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
