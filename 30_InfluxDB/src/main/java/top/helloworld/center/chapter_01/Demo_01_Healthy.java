package top.helloworld.center.chapter_01;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.junit.Test;

public class Demo_01_Healthy {

    @Test
    public void healthy() {
        String address = "http://192.168.220.201:8086/";
        String token = "qLPRCB8-8K46drxw7L1M1O2ClN8QO6-j66-1Ow6jDEoRnvMDbkDjtk5jzdKTPsLj-GM0Kaaff6hcZyYGjH8lIg==";

        // 创建客户端
        InfluxDBClient client = InfluxDBClientFactory.create(address);
        Boolean ping = client.ping();
        System.out.println(ping);
    }
}
