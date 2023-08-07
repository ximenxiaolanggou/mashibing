package top.helloworld.center.chapter_02;

import cn.hutool.json.JSONUtil;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxTable;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public class Demo_01_Write_Point {


    public static void main(String[] args) {
        String org = "damoncai";
        String bucket = "example_java";
        String address = "http://192.168.220.201:8086/";
        String token = "qLPRCB8-8K46drxw7L1M1O2ClN8QO6-j66-1Ow6jDEoRnvMDbkDjtk5jzdKTPsLj-GM0Kaaff6hcZyYGjH8lIg==";

        // 创建客户端
        InfluxDBClient client = InfluxDBClientFactory.create(address, token.toCharArray(), org, bucket);

        // 获取查询API
        WriteApiBlocking writeApi = client.getWriteApiBlocking();

        Point point = Point.measurement("temperature")
                .addTag("location", "west")
                .addField("value", 55D)
                .time(Instant.now(), WritePrecision.MS);

//        System.out.println(point.toLineProtocol());

//        writeApi.writePoint(point);
        writeApi.writeRecord(WritePrecision.MS, "temperature,location=north value=35");
        client.close();
    }
}
