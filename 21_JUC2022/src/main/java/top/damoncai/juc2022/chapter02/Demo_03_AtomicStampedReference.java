package top.damoncai.juc2022.chapter02;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference  携带版本信息
 */
public class Demo_03_AtomicStampedReference {

    public static void main(String[] args) {
        AtomicStampedReference<String> reference = new AtomicStampedReference<>("A", 1);

        String oValue = reference.getReference();
        int oVersion = reference.getStamp();

        boolean res = reference.compareAndSet(oValue, "B", oVersion, oVersion + 1);
        System.out.println("res：" + res);

        res = reference.compareAndSet(oValue, "C", oVersion, oVersion + 1);
        System.out.println("res：" + res);
    }
}
