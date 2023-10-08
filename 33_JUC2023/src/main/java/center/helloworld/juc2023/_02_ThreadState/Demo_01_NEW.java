package center.helloworld.juc2023._02_ThreadState;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 新建状态
 */
public class Demo_01_NEW {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("子线程运行~~");
        });

        System.out.println(t1.getState());
    }
}
