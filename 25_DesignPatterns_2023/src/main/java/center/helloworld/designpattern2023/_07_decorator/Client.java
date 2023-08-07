package center.helloworld.designpattern2023._07_decorator;

/**
 * @author zhishun.cai
 * @create 2023/7/13
 * @note
 */
public class Client {

    public static void main(String[] args) {
        // 创建文件data loader
        DataLoader dataLoader = new BaseFileDataLoader();

        // 创建加解密装饰器
        DataLoader encryptionDataDecorator = new EncryptionDataDecorator(dataLoader);

        encryptionDataDecorator.write("hello designer pattern");

        String res = encryptionDataDecorator.read();
        System.out.println("读取结果：" + res);
    }
}
