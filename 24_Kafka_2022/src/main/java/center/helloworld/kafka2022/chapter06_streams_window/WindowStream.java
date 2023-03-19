package center.helloworld.kafka2022.chapter06_streams_window;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.Windowed;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * 拷贝streams,将topic 1 中的数据拷贝到 topic 2中
 */
public class WindowStream {

    public static void main(String[] args) {
        Properties prop =new Properties();
        prop.put(StreamsConfig.APPLICATION_ID_CONFIG,"window_stream");
        prop.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.220.201:9092"); //zookeeper的地址
        prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        prop.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,2000);  //提交时间设置为2秒
        prop.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass()); //输入key的类型
        prop.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());  //输入value的类型

        StreamsBuilder builder = new StreamsBuilder();
        KStream<Object, Object> source = builder.stream("window-input");
        KTable<Windowed<String>, Long> countKtable = source.flatMapValues(value -> Arrays.asList(value.toString().split("s+")))
                .map((x, y) -> {
                    return new KeyValue<String, String>(y, "1");
                }).groupByKey()
                //加5秒窗口,按步长2秒滑动  Hopping Time Window
                .windowedBy(TimeWindows.of(Duration.ofSeconds(5)).advanceBy(Duration.ofSeconds(2)))
                //.windowedBy(SessionWindows.with(Duration.ofSeconds(15).toMillis()))
                .count();

        //为了方便查看，输出到控制台
        countKtable.toStream().foreach((x,y)->{
            System.out.println("x: "+x+"  y: "+y);
        });

        System.out.println("====================end");

        countKtable.toStream().map((x,y)-> {
            return new KeyValue<String, String>(x.toString(), y.toString());
        }).to("cell3");

        final Topology topo=builder.build();
        final KafkaStreams streams = new KafkaStreams(topo, prop);

        final CountDownLatch latch = new CountDownLatch(1);
        Runtime.getRuntime().addShutdownHook(new Thread("stream"){
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });
        try {
            streams.start();
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
