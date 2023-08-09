package top.helloworld.center.chapter_05;

import cn.hutool.json.JSONUtil;
import com.influxdb.client.*;
import com.influxdb.client.domain.WritePrecision;
import org.junit.Test;
import top.helloworld.center.entity.Cycle;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhishun.cai
 * @create 2023/8/8
 * @note
 */
public class Demo_01_Cycle {

    private AtomicInteger id = new AtomicInteger(1);

    @Test
    public void test() {


        String org = "damoncai";
        String bucket = "cycle";
        String address = "http://192.168.100.200:8086/";
        String token = "pc4PvfHk6TXMg-Fe1zRSdDkv5VMQJhwpJCMhofaCXRItqnpYeCE8mJavvtQPm84DHZxjdBfst5fXSAc-k7MS-A==";

        // 创建客户端
        InfluxDBClient client = InfluxDBClientFactory.create(address, token.toCharArray(), org, bucket);
        // 获取查询API
        WriteOptions options = WriteOptions.builder()
                .batchSize(10000)
                .flushInterval(1000)
                .build();
        WriteApi writeApi = client.makeWriteApi(options);

        Long mold_id = 1L;

        Instant instant = Instant.now().now();

        for (long i = 1; i <= 20; i++) {
            for (int j = 1 ; j <= 2000000; j++) {
                instant = instant.plusSeconds(1L);
//                Cycle cycle = new Cycle(mold_id, i, id.getAndIncrement(),j,4,instant.toEpochMilli() / 1000, instant);
//                writeApi.writeMeasurement(WritePrecision.S, cycle);
                System.out.println(id.get());
            }
        }
        writeApi.flush();
        writeApi.close();

    }

    @Test
    public void query() {


        String org = "damoncai";
        String bucket = "cycle";
        String address = "http://192.168.100.200:8086/";
        String token = "pc4PvfHk6TXMg-Fe1zRSdDkv5VMQJhwpJCMhofaCXRItqnpYeCE8mJavvtQPm84DHZxjdBfst5fXSAc-k7MS-A==";

        // 创建客户端
        InfluxDBClient client = InfluxDBClientFactory.create(address, token.toCharArray(), org, bucket);
        // 获取查询API
        WriteOptions options = WriteOptions.builder()
                .batchSize(10000)
                .flushInterval(1000)
                .build();
        QueryApi queryApi = client.getQueryApi();

        String flux =
                "from(bucket: \"cycle\")\n" +
                        "  |> range(start: -5y, stop: 5y)\n" +
                        "  |> filter(fn: (r) => r[\"_measurement\"] == \"cycle\")\n" +
                        "  |> filter(fn: (r) => r[\"mold_id\"] == \"1\" and r[\"pro_id\"] == \"2\")\n" +
                        "  |> limit(n: 1)\n";
        List<Cycle> cycles = queryApi.query(flux, Cycle.class);
        System.out.println(JSONUtil.toJsonStr(queryApi.query(flux)));
        System.out.println(cycles);

    }

    public static void main(String[] args) {
        System.out.println(Instant.now().now().toEpochMilli());
    }
}
