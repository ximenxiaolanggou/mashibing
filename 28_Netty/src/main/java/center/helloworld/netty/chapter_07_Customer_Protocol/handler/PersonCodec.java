package center.helloworld.netty.chapter_07_Customer_Protocol.handler;

import center.helloworld.netty.chapter_07_Customer_Protocol.entity.Person;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.List;

public class PersonCodec extends ByteToMessageCodec<Person> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Person msg, ByteBuf buffer) throws Exception {
        // 头部消息 协议名称（4字节）、版本（2字节）、4字节表示数据长度
        String por_name = "MQTT";
        String version = "05";


        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(msg);
        byte[] bytes = bos.toByteArray();
        int len = bytes.length;
        buffer.writeBytes(por_name.getBytes());
        buffer.writeBytes(version.getBytes());
        buffer.writeInt(len);
        buffer.writeBytes(bytes);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 协议名称
        byte[] pro_name_byte = new byte[4];
        in.readBytes(pro_name_byte, 0 , 4);

        // 版本号
        byte[] pro_version_byte = new byte[2];
        in.readBytes(pro_version_byte, 0 , 2);

        // 数据包长度
        int length = in.readInt();
        byte[] pro_data_length_byte = new byte[length];
        in.readBytes(pro_data_length_byte, 0, length);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(pro_data_length_byte));

        Person person = (Person) ois.readObject();

        System.out.println("person：" + person);

        out.add(person);
    }
}
