package center.helloworld.jdk.chapter_01_Jdk_09;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note transferto
 */
public class Demo_05_transferto {

    /**
     * transferto
     */
    @Test
    public void transferto() throws FileNotFoundException {
        InputStream inputStream =new FileInputStream("d:/aaa.txt");
        OutputStream outputStream=new FileOutputStream("d:/bbb.txt");
        try (inputStream;outputStream){
            inputStream.transferTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
