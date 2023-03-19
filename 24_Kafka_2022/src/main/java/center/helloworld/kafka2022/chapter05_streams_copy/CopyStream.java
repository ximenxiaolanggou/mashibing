package center.helloworld.kafka2022.chapter05_streams_copy;


import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * 拷贝streams,将topic 1 中的数据拷贝到 topic 2中
 */
public class CopyStream {

    public static void main(String[] args) {
        Properties prop =new Properties();
        prop.put(StreamsConfig.APPLICATION_ID_CONFIG,"copy_stream");
        prop.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.220.201:9092"); //zookeeper的地址
        prop.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass()); //输入key的类型
        prop.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());  //输入value的类型

        //创建流构造器
        StreamsBuilder builder = new StreamsBuilder();

        //构建好builder，将myStreamIn topic中的数据写入到myStreamOut topic中
        builder.stream("cell1").to("cell2");

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
