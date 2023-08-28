package center.helloworld.jdk.chapter_04_Jdk_12;

import center.helloworld.jdk.enums.Month;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note 数字压缩
 */
public class Demo_02_CompactNumber {

   @Test
   public void common() {
      var cnf = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.SHORT);
      System.out.println(cnf.format(1_0000));
      System.out.println(cnf.format(1_9200));
      System.out.println(cnf.format(1_000_000));
      System.out.println(cnf.format(1L << 30));
      System.out.println(cnf.format(1L << 40));
      System.out.println(cnf.format(1L << 50));
   }
}
