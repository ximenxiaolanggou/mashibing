import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import top.damoncai.kafka.App;

/**
 * @author zhishun.cai
 * @date 2021/2/24 9:31
 */

@SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    private KafkaTemplate<String,String> template;

    @org.junit.Test
    public void produce() {
        template.send("topic01","key","value");
    }

    /**
     * 如果生产者开始事务   transaction-id-prefix: transaction-id-
     * 1.不能使用普通的发送消息
     * 2.需要使用事务执行
     *
     * SpringBoot中如果写在@Transaction下就可以直接使用template.send()方法
     */
    @org.junit.Test
    public void produceTransaction() {
        template.executeInTransaction(new KafkaOperations.OperationsCallback<String, String, Object>() {
            @Override
            public Object doInOperations(KafkaOperations kafkaOperations) {
                return kafkaOperations.send(new ProducerRecord("topic01","key","value transaction"));
            }
        });
    }
}
