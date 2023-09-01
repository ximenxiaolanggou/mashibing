package top.helloworld.center.chapter_04;

import cn.hutool.json.JSONUtil;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxTable;
import org.junit.Test;
import top.helloworld.center.entity.Person;

import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/8/7
 * @note
 */
public class Demo_01_Query {

    @Test
    public void query() {
        String org = "damoncai";
        String bucket = "example_java";
        String address = "http://192.168.100.200:8086/";
        String token = "pc4PvfHk6TXMg-Fe1zRSdDkv5VMQJhwpJCMhofaCXRItqnpYeCE8mJavvtQPm84DHZxjdBfst5fXSAc-k7MS-A==";

        // 创建客户端
        InfluxDBClient client = InfluxDBClientFactory.create(address, token.toCharArray(), org, bucket);

        QueryApi queryApi = client.getQueryApi();

        String queryShell =
                "from(bucket: \"example_java\")\n" +
                        "  |> range(start: -2h)\n" +
                        "  |> filter(fn: (r) => r[\"_measurement\"] == \"person\")\n" +
                        "  |> filter(fn: (r) => r[\"gender\"] == \"男\")\n";

        List<FluxTable> res = queryApi.query(queryShell);
        List<Person> res2 = queryApi.query(queryShell, Person.class);

        System.out.println(JSONUtil.toJsonStr(res));
        System.out.println(JSONUtil.toJsonStr(res2));
    }




    @Test
    public void queryRow() {
        String org = "damoncai";
        String bucket = "example_java";
        String address = "http://192.168.100.200:8086/";
        String token = "pc4PvfHk6TXMg-Fe1zRSdDkv5VMQJhwpJCMhofaCXRItqnpYeCE8mJavvtQPm84DHZxjdBfst5fXSAc-k7MS-A==";

        // 创建客户端
        InfluxDBClient client = InfluxDBClientFactory.create(address, token.toCharArray(), org, bucket);

        QueryApi queryApi = client.getQueryApi();

        String queryShell =
                "from(bucket: \"example_java\")\n" +
                        "  |> range(start: -2h)\n" +
                        "  |> filter(fn: (r) => r[\"_measurement\"] == \"person\")\n" +
                        "  |> filter(fn: (r) => r[\"gender\"] == \"男\")\n";

        String res = queryApi.queryRaw(queryShell);
        System.out.println(JSONUtil.toJsonStr(res));

    }
}
