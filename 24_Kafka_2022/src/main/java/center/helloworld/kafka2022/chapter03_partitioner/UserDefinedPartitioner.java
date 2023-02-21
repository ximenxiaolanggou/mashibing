package center.helloworld.kafka2022.chapter03_partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.utils.Utils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhishun.cai
 * @date 2021/2/23 11:35
 * 自定义分区
 */

public class UserDefinedPartitioner implements Partitioner {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    public int partition(String topic, Object o, byte[] keyBytes, Object o1, byte[] bytes1, Cluster cluster) {
        //自定义分区规则
        int numPartitions = cluster.partitionsForTopic(topic).size();
        if(keyBytes==null || keyBytes.length==0){
            return atomicInteger.addAndGet(1) & Integer.MAX_VALUE% numPartitions;
        } else {
            return Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;
        }
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println("============================== Configure ==============================");
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
        System.out.println("============================== End ==============================");
    }
}
