package top.damoncai.juc2022.chapter03;

/**
 * synchronized类锁和对象锁
 */
public class Demo_01_synchronized_Class_Obj {


}

class Test {
    // 类锁 Test.class
    public static synchronized void a() {

    }

    // 对象锁 this
    public synchronized void b() {

    }
}
