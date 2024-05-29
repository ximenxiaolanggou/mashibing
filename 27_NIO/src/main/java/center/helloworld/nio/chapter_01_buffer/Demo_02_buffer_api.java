package center.helloworld.nio.chapter_01_buffer;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhishun.cai
 * @create 2023/5/8
 * @note buffer api 使用
 */

@Slf4j
public class Demo_02_buffer_api {


    /**
     * 初始化内容
     */
    @Before
    public void before() throws FileNotFoundException {
    }

    /**
     * 销毁内容
     */
    @After
    public void after() throws IOException {
    }

    @Test
    public void base_1() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(10);
    }

    @Test
    public void t() {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.flip();
        System.out.println(buffer.get());
        System.out.println(buffer.get());
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());

    }
}
