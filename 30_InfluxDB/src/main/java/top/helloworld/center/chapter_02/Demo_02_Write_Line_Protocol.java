package top.helloworld.center.chapter_02;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.junit.Test;

import java.time.Instant;

public class Demo_02_Write_Line_Protocol {


    /**
     * 行协议写入数据
     */
    @Test
    public void lineProtocol() {
        String org = "damoncai";
        String bucket = "example_java";
        String address = "http://192.168.100.200:8086/";
        String token = "pc4PvfHk6TXMg-Fe1zRSdDkv5VMQJhwpJCMhofaCXRItqnpYeCE8mJavvtQPm84DHZxjdBfst5fXSAc-k7MS-A==";

        // 创建客户端
        InfluxDBClient client = InfluxDBClientFactory.create(address, token.toCharArray(), org, bucket);

        // 获取查询API
        WriteApiBlocking writeApi = client.getWriteApiBlocking();

        writeApi.writeRecord(WritePrecision.MS, "temperature,location=west value=38.8");
        client.close();
    }
}
