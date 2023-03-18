package center.helloworld.designpattern2023._01_singleton.example_05;

import center.helloworld.designpattern2023._01_singleton.example_04.Singleton_04;

/**
 * @author zhishun.cai
 * @create 2023/3/13
 * @note
 */
public class Client {

    public static void main(String[] args) {

        for (int i = 0; i < 400; i++) {
            new Thread(() -> {
                Singleton_05 instance = Singleton_05.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
