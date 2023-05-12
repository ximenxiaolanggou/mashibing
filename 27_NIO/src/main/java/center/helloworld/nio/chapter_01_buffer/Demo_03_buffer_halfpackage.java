package center.helloworld.nio.chapter_01_buffer;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author zhishun.cai
 * @create 2023/5/8
 * @note 半包 粘包问题
 */

@Slf4j
public class Demo_03_buffer_halfpackage {


    @Test
    public void base_1() throws IOException {
        ByteBuffer source = ByteBuffer.allocate(32);
        //                     11            24
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);

        source.put("w are you?\nhaha!\n".getBytes());
        split(source);
    }

    /**
     * 处理
     * @param source
     */
    public void split(ByteBuffer source) {
        source.flip();
        int oldLimit = source.limit();
        for (int i = 0; i < oldLimit; i++) {
            byte item = source.get(i);
            if(item == '\n'){
                ByteBuffer collect = ByteBuffer.allocate(i - source.position() + 1);
                source.limit(i + 1);
                collect.put(source);
                collect.flip();
                CharBuffer buffer3 = StandardCharsets.UTF_8.decode(collect);
                System.out.println(buffer3.toString());
                collect.clear();
                source.limit(oldLimit);
            }
        }
        source.compact();
    }
}
