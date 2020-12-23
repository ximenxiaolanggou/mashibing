package top.damoncai.juc.c_022_RefTypeAndThreadLocal;

/**
 * @author zhishun.cai
 * @date 2020/12/19 14:58
 */

public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("GG");
    }
}
