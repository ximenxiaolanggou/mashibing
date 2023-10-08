package center.helloworld.juc2023._04_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note sleep
 */
public class Demo_05_Sleep {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
    }
}
