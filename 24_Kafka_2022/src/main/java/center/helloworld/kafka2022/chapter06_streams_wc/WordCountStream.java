package center.helloworld.kafka2022.chapter06_streams_wc;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.KTable;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * 拷贝streams,将topic 1 中的数据拷贝到 topic 2中
 */
public class WordCountStream {

    public static void main(String[] args) {
        Properties prop =new Properties();
        prop.put(StreamsConfig.APPLICATION_ID_CONFIG,"wordcount_stream");
        prop.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.220.201:9092"); //zookeeper的地址
        prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        prop.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,2000);  //提交时间设置为2秒
        prop.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass()); //输入key的类型
        prop.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());  //输入value的类型

        StreamsBuilder builder = new StreamsBuilder();
        KTable<String, Long> count = builder.stream("wordcount-input") //从kafka中一条一条取数据
                .flatMapValues(                //返回压扁后的数据
                        (value) -> {           //对数据按空格进行切割，返回List集合
                            String[] split = value.toString().split(" ");
                            List<String> strings = Arrays.asList(split);
                            return strings;
                        })  //null hello,null world,null hello,null java
                .map((k, v) -> {
                    return new KeyValue<String, String>(v,"1");
                }).groupByKey().count();

        count.toStream().foreach((k,v)->{
            //为了测试方便，我们将kv输出到控制台
            System.out.println("key:"+k+"   "+"value:"+v);
        });

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
