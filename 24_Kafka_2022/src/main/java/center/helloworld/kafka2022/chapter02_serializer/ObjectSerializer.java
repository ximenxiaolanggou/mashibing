package center.helloworld.kafka2022.chapter02_serializer;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Serializer;

import java.io.Serializable;
import java.util.Map;

/**
 * @author zhishun.cai
 * @date 2021/2/23 12:34
 */

public class ObjectSerializer implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {
        System.out.println("configure");
    }

    @Override
    public byte[] serialize(String topic, Object data) {
        return SerializationUtils.serialize((Serializable) data);
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
