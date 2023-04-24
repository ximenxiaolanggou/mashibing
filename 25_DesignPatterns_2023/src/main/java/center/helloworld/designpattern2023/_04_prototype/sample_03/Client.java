package center.helloworld.designpattern2023._04_prototype.sample_03;

import java.io.*;

/**
 * @author zhishun.cai
 * @create 2023/3/27
 * @note
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        // 创建person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(12);

        String path = "d:\\A.txt";

        ConcretePrototype concretePrototype = new ConcretePrototype(person);

        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
        oos.writeObject(concretePrototype);
        oos.close();

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
        ConcretePrototype clonePrototype = (ConcretePrototype) ois.readObject();
        ois.close();

        System.out.println("外层对象是否相等：" + (concretePrototype == clonePrototype));
        System.out.println("person对象是否相等：" + (concretePrototype.getPerson() == clonePrototype.getPerson()));
    }
}
