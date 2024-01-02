package center.hellowrold.so._03_java_jvm;

/**
 * @author zhishun.cai
 * @create 2023/12/5
 * @note
 */
public class _01_Static {


    static  {
        a = 2;
    }
    public static int a = 1;

    public static void main(String[] args) {
        // 这里输出为1，静态成员属性赋值和静态代码快执行，按从上往下执行，部分先后
        System.out.println(a);
    }
}
