package center.helloworld.jdk.chapter_04_Jdk_12;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 字符串 Transform操作
 */
public class Demo_03_String_Transform {

   @Test
   public void transform() {
      String str = " www.baidu.com ";
      String resStr = str.strip().transform(e -> "https://" + e).transform(e -> e.toUpperCase());
      System.out.println(str);
      System.out.println(resStr);
   }
}
