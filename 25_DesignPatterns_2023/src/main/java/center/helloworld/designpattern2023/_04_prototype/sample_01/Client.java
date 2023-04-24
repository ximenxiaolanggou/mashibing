package center.helloworld.designpattern2023._04_prototype.sample_01;

/**
 * @author zhishun.cai
 * @create 2023/3/27
 * @note
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePrototype concretePrototype = new ConcretePrototype();

        ConcretePrototype clonePrototype = concretePrototype.clone();

        System.out.println("对象是否相同：" + (concretePrototype == clonePrototype));

    }
}
