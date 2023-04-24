package center.helloworld.designpattern2023._04_prototype.sample_01;

/**
 * @author zhishun.cai
 * @create 2023/3/27
 * @note
 */
public class ConcretePrototype implements Cloneable{

    public ConcretePrototype() {
        System.out.println("创建对象~~~");
    }

    @Override
    protected ConcretePrototype clone() throws CloneNotSupportedException {
        return (ConcretePrototype) super.clone();
    }
}
