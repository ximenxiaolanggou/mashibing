package center.helloworld.jdk.chapter_04_Jdk_12;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note File操作 Mismatch
 */
public class Demo_05_File_Mismatch {

   @Test
   public void misMatch() throws IOException {
       FileWriter fileWriter = new FileWriter("d:/a.txt");
       fileWriter.write("a");
       fileWriter.write("b");
       fileWriter.write("c");
       fileWriter.close();
       FileWriter fileWriterB = new FileWriter("d:/b.txt");
       fileWriterB.write("a");
       fileWriterB.write("1");
       fileWriterB.write("c");
       fileWriterB.close();
       System.out.println(Files.mismatch(Path.of("d:/a.txt"),Path.of("d:/b.txt")));
   }
}
