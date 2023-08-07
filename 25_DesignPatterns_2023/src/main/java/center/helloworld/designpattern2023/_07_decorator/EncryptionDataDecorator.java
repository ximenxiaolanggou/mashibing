package center.helloworld.designpattern2023._07_decorator;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author zhishun.cai
 * @create 2023/7/13
 * @note
 */
public class EncryptionDataDecorator extends DataLoaderDecorator{


    public EncryptionDataDecorator(DataLoader dataLoader) {
        super(dataLoader);
    }


    @Override
    public String read() {
        String data = super.read();
        return decode(data);
    }

    /**
     * 数据保存前base64加密
     * @param data
     */
    @Override
    public void write(String data) {
        super.write(encode(data));
    }

    /**
     * base64编码
     * @param data
     * @return
     */
    private String encode(String data) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * base64解码
     * @param data
     * @return
     */
    private String decode(String data) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(data);
        return new String(decode, StandardCharsets.UTF_8);
    }
}
