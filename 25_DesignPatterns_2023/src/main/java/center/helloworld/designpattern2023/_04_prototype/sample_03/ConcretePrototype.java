package center.helloworld.designpattern2023._04_prototype.sample_03;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhishun.cai
 * @create 2023/3/27
 * @note
 */
@Data
public class ConcretePrototype implements Cloneable, Serializable {

    private Person person;

    public ConcretePrototype() {
        System.out.println("创建对象~~~");
    }

    public ConcretePrototype(Person person) {
        this();
        this.person = person;
    }

    @Override
    protected ConcretePrototype clone() throws CloneNotSupportedException {
        return (ConcretePrototype) super.clone();
    }
}
