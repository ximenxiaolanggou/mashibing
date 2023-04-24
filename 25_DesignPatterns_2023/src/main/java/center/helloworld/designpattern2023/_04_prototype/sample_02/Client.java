package center.helloworld.designpattern2023._04_prototype.sample_02;

/**
 * @author zhishun.cai
 * @create 2023/3/27
 * @note
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(12);

        ConcretePrototype concretePrototype = new ConcretePrototype(person);

        ConcretePrototype clonePrototype = concretePrototype.clone();

        System.out.println("外层对象是否相等：" + (concretePrototype == clonePrototype));

        System.out.println("person对象是否相等：" + (concretePrototype.getPerson() == clonePrototype.getPerson()));
    }
}
