package center.helloworld.juc2023._08_ThreadPool;

/**
 * @author zhishun.cai
 * @create 2023/10/23
 * @note
 */
public class Test {

    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}
