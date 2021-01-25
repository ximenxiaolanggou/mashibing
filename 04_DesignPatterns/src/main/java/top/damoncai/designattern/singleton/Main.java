package top.damoncai.designattern.singleton;

/**
 * @author zhishun.cai
 * @date 2021/1/21 16:30
 */

public class Main {

    public static void main(String[] args) {
        for(int i = 0 ; i < 100 ; i++) {
            new Thread(() -> System.out.println(Mgr05.getInstance().hashCode())).start();
        }
    }
}
