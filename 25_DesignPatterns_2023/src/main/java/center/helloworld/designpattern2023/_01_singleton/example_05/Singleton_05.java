package center.helloworld.designpattern2023._01_singleton.example_05;

/**
 * 单例模式 - 枚举
 * @author zhishun.cai
 * @create 2023/3/13
 * @note
 */
public enum Singleton_05 {

   INSTANCE;

   private String name;

   private Integer age;


   Singleton_05(String name, Integer age) {
       this.name = name;
       this.age = age;
   }
   Singleton_05() {

   }

   public static Singleton_05 getInstance() {
       return INSTANCE;
   }

}
