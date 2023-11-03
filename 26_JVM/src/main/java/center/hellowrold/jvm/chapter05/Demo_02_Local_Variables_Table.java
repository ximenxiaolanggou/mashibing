package center.hellowrold.jvm.chapter05;

/**
 * @author zhishun.cai
 * @create 2023/11/1
 * @note 局部变量表
 */
public class Demo_02_Local_Variables_Table {

    public static int methodA(String name) {
        int age = 12;
        char sex = 'S';
        return age;
    }

    public int methodB(String name) {
        int age = 12;
        char sex = 'S';
        return age;
    }

    public int methodC(String name) {
        int age = 12;
        double weight = 64.0;
        boolean joker = false;
        return age;
    }

    public void methodD() {
        {
            int a = 0;
            System.out.println(a);
        }
        //此时的就会复用a的槽位
        int b = 0;
    }
}
