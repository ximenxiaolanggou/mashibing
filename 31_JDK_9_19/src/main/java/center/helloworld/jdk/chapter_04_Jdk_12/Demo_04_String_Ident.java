package center.helloworld.jdk.chapter_04_Jdk_12;

import org.junit.Test;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 字符串 Ident操作
 */
public class Demo_04_String_Ident {

   @Test
   public void ident() {
     String str = "java\nscala\npython";
      String resStr = str.indent(3);
      System.out.println(resStr);
   }
}
