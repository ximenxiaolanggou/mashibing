package center.helloworld.designpattern2023._01_singleton.example_04;

import center.helloworld.designpattern2023._01_singleton.example_01.Singleton_01;
import center.helloworld.designpattern2023._01_singleton.example_03.Singleton_03;

/**
 * @author zhishun.cai
 * @create 2023/3/13
 * @note
 */
public class Client {

    public static void main(String[] args) {

        for (int i = 0; i < 400; i++) {
            new Thread(() -> {
                Singleton_04 instance = Singleton_04.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
