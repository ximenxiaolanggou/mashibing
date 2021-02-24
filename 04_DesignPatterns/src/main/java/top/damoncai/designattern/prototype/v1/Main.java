package top.damoncai.designattern.prototype.v1;

/**
 * @author zhishun.cai
 * @date 2021/1/28 14:06
 */

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("damoncai",12,new Location("上海"));

        Person person1 = (Person) person.clone();

        System.out.println("person == person1 " + (person == person1));

        //值为 true浅克隆
        System.out.println("person.loc == person1.loc " + (person.getLoc() == person1.getLoc()));

    }
}
