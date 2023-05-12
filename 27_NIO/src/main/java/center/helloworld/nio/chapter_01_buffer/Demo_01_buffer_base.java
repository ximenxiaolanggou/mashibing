package center.helloworld.nio.chapter_01_buffer;

import cn.hutool.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhishun.cai
 * @create 2023/5/8
 * @note
 *  nio三大组件 - buffer基本使用
 *  这里会采用到文件通道
 */

@Slf4j
public class Demo_01_buffer_base {

    // 数据路径
    public String dataPath = "src/data.txt";

    // 缓存数据大小
    public int bufferCapacity = 10;

    /**
     * 文件通道
     */
    FileChannel fileChannel = null;


    /**
     * 初始化内容
     */
    @Before
    public void before() throws FileNotFoundException {
        fileChannel = new FileInputStream(dataPath).getChannel();
    }

    /**
     * 销毁内容
     */
    @After
    public void after() throws IOException {
        if(fileChannel != null)
            fileChannel.close();
    }

    @Test
    public void base_1() throws IOException {
        // 创建缓冲 - 创建后默认是写入模式
        ByteBuffer buffer = ByteBuffer.allocate(bufferCapacity);

        // 读取文件字节数
        int len = -1;

        while ((len = fileChannel.read(buffer)) != -1) {
            log.info("读取长度为：{}", len);
            // 切换至读模式
            buffer.flip();
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                log.info("读取数据为：{}", (char) b);
            }
            // 切换至写模式
            buffer.clear();
        }
    }
}
