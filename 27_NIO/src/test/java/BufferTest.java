import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author zhishun.cai
 * @create 2024/3/12
 * @note
 */
public class BufferTest {

    @Test
    public void test() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
        System.out.println("=================");
        buffer.put("he".getBytes(StandardCharsets.UTF_8));
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
        System.out.println("=================");
        buffer.flip();
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
    }
}
