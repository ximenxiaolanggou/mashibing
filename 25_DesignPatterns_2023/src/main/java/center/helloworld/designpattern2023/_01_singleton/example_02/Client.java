package center.helloworld.designpattern2023._01_singleton.example_02;

import center.helloworld.designpattern2023._01_singleton.example_01.Singleton_01;

/**
 * @author zhishun.cai
 * @create 2023/3/13
 * @note
 */
public class Client {


    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            new Thread(() -> {
                Singleton_02 singleton = Singleton_02.getSingleton();
                System.out.println(singleton);
            }).start();
        }
    }
}
