package top.helloworld.center.chapter_03;

import com.influxdb.client.*;
import com.influxdb.client.domain.WritePrecision;
import org.junit.Test;
import top.helloworld.center.entity.Person;

import java.time.Instant;

/**
 * @author zhishun.cai
 * @create 2023/8/7
 * @note
 */
public class Demo_01_No_Blocking {


    @Test
    public void test() {
        String org = "damoncai";
        String bucket = "example_java";
        String address = "http://192.168.100.200:8086/";
        String token = "pc4PvfHk6TXMg-Fe1zRSdDkv5VMQJhwpJCMhofaCXRItqnpYeCE8mJavvtQPm84DHZxjdBfst5fXSAc-k7MS-A==";

        // 创建客户端
        InfluxDBClient client = InfluxDBClientFactory.create(address, token.toCharArray(), org, bucket);

        WriteOptions writeOptions = WriteOptions.builder()
                .batchSize(10)
                .build();

        // 获取查询API
        WriteApi writeApi = client.makeWriteApi(writeOptions);

        Person person = new Person("男", "王五",12, Instant.now());
        writeApi.writeMeasurement(WritePrecision.MS, person);

        // 异步存储数据，会使得数据存储在缓冲区中，直到缓冲区满或者到达写入时间， flush和close都可以触发数据写入
        writeApi.flush();
        client.close();
    }
}
