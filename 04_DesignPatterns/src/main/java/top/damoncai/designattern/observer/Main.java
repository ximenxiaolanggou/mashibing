package top.damoncai.designattern.observer;

/**
 * @author zhishun.cai
 * @date 2021/1/24 14:08
 */

public class Main {
    public static void main(String[] args) {

        DadObserver dadObserver = new DadObserver();
        MomObserver momObserver = new MomObserver();


        Child child = new Child();
        child.setName("花花");
        child.setObservers(dadObserver).setObservers(momObserver);

        child.wake();

        System.out.println("=====================");

        child.laugh();
    }
}
