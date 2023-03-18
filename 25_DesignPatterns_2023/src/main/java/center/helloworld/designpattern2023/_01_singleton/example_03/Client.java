package center.helloworld.designpattern2023._01_singleton.example_03;

/**
 * @author zhishun.cai
 * @create 2023/3/13
 * @note
 */
public class Client {


    public static void main(String[] args) {
        for (int i = 0; i < 400; i++) {
            new Thread(() -> {
                Singleton_03 singleton = Singleton_03.getSingleton();
                System.out.println(singleton);
            }).start();
        }
    }
}
