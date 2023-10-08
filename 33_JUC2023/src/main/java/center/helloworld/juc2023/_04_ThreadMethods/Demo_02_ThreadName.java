package center.helloworld.juc2023._04_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 设置和获取线程名称
 */
public class Demo_02_ThreadName {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {}, "模块名称-功能名称-序号");

        // 可以通过构造方法设置线程名称,也可以通过set方法设置
        t1.setName("模块名称-功能名称-序号");
        System.out.println(t1.getName());
    }
}
