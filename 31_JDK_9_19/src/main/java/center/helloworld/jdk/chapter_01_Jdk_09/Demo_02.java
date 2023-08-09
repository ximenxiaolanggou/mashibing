package center.helloworld.jdk.chapter_01_Jdk_09;

import center.helloworld.jdk.entity.Person;

import java.util.Comparator;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 具体实现类也可以通过匿名内部类写法
 */
public class Demo_02 {

    public static void main(String[] args) {

        /*
         * 匿名内部类仅仅在接口和抽象类上使用,作为一种快速的实现方式
         * JAVA9中,普通类也可以借助这种语法形式实现对方法的快速临时的重写
         */
       new Person() {
           @Override
           public void eat() {
               super.eat();
           }
       };
    }
}
