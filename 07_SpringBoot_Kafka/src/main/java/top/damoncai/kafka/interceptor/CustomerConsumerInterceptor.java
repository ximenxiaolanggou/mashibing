package top.damoncai.kafka.interceptor;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.internals.ConsumerInterceptors;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.internals.Topic;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author zhishun.cai
 * @date 2021/9/26 9:38
 */

public class CustomerConsumerInterceptor implements ConsumerInterceptor {
    @Override
    public ConsumerRecords onConsume(ConsumerRecords consumerRecords) {
        Map<TopicPartition,List<ConsumerRecord>> resMap = new HashMap<>(consumerRecords.count());
        Set<TopicPartition> topicPartitions = consumerRecords.partitions();
        for (TopicPartition topicPartition : topicPartitions) {
            List<ConsumerRecord> filterRecords = new ArrayList<>();
            List<ConsumerRecord> records = consumerRecords.records(topicPartition);
            for (ConsumerRecord record : records) {
                if("004".equals(record.key())) {
                    filterRecords.add(record);
                }
            }
            if(!CollectionUtils.isEmpty(filterRecords)) {
                resMap.put(topicPartition,filterRecords);
            }
        }
        return new ConsumerRecords(resMap);
    }

    @Override
    public void close() {
        System.out.println("close ~~~");
    }

    @Override
    public void onCommit(Map map) {
        System.out.println("onCommit ~~~");
    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println("configure ~~~");
    }
}
