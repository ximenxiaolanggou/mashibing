package top.helloworld.center.chapter_02;

import cn.hutool.json.JSONUtil;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxTable;
import io.gsonfire.util.JsonUtils;
import org.junit.Test;

import java.util.List;

public class Demo_01_Query {


    @Test
    public void test() {
        String org = "damoncai";
        String bucket = "java";
        String address = "http://192.168.220.201:8086/";
        String token = "qLPRCB8-8K46drxw7L1M1O2ClN8QO6-j66-1Ow6jDEoRnvMDbkDjtk5jzdKTPsLj-GM0Kaaff6hcZyYGjH8lIg==";

        // 创建客户端
        InfluxDBClient client = InfluxDBClientFactory.create(address, token.toCharArray(), org, bucket);

        // 获取查询API
        QueryApi queryApi = client.getQueryApi();

        String queryFlux =
                "from(bucket: \"java\")\n" +
                        "  |> range(start: -1h)\n" +
                        "  |> filter(fn: (r) => r[\"_measurement\"] == \"person\")";
        List<FluxTable> query = queryApi.query(queryFlux);
        for (FluxTable fluxTable : query) {
            System.out.println(JSONUtil.toJsonStr(fluxTable));
        }
    }
}
