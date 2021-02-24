package top.damoncai.designattern.templatemethod;

/**
 * @author zhishun.cai
 * @date 2021/1/28 21:17
 */

public class F {
    void say(){
        say1();
        say2();
    }

    void say1() {
        System.out.println("F1");
    }

    void say2() {
        System.out.println("F2");
    }
}

class C extends F{

    void say2() {
        System.out.println("C2");
    }

    public static void main(String[] args) {
        F c = new C();
        c.say();
    }
}
