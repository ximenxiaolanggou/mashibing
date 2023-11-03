package center.hellowrold.jvm.chapter05;

/**
 * @author zhishun.cai
 * @create 2023/11/1
 * @note 栈溢出演示
 */
public class Demo_01_StackOverflow {

    private static Integer count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
