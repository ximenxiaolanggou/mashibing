package center.helloworld.jdk.chapter_04_Jdk_12;

import center.helloworld.jdk.enums.Month;
import org.junit.Test;

import java.util.Comparator;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note Switch
 */
public class Demo_01_Switch {

   /**
    * JDK 12 之前switch写法
    */
   @Test
   public void common() {
      Month month=Month.APRIL;
      String season;
      switch (month){
         case DECEMBER:
         case JANUARY:
         case FEBRUARY:
            season="winter";
            break;
         case MARCH:
         case APRIL:
         case MAY:
            season="spring";
            break;
         case JUNE:
         case JULY:
         case AUGUST:
            season="summer";
            break;
         case SEPTEMBER:
         case OCTOBER:
         case NOVEMBER:
            season="autumn";
            break;
         default:
            throw new RuntimeException("NoSuchMonthException");
      }
      System.out.println(season);
   }

   /**
    * java12 之后,switch语句可以如下
    */
   @Test
   public void switchJDK12() {
      Month month=Month.APRIL;
      String season;
      switch (month) {
         case DECEMBER,JANUARY,FEBRUARY -> season = "winter";
         case MARCH, APRIL, MAY -> season = "spring";
         case JUNE, JULY, AUGUST -> season = "spring";
         case SEPTEMBER, OCTOBER, NOVEMBER -> season = "spring";
         default -> {
            System.out.println("Default");
            throw new RuntimeException("NoSuchMonth");
         }
      }
      System.out.println(season);
   }
}
