import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.damoncai.kafka.App;

/**
 * @author zhishun.cai
 * @date 2021/9/16 15:54
 */

@SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class TestDemo {

    @Autowired
    private KafkaTemplate<String,String> template;

    @Test
    public void demo() throws InterruptedException {
        int start = 0;
        int end = 20000;
        while (true) {
            int finalStart = start;
            int finalEnd = end;
            template.executeInTransaction(new KafkaOperations.OperationsCallback<String, String, Object>() {
                @Override
                public Object doInOperations(KafkaOperations kafkaOperations) {
                    for (int i = finalStart; i < finalEnd; i++) {
                        kafkaOperations.send("topic-test","key1","16:15:20.307 [main] DEBUG oraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaag.springframework.test.context.junit4.SpringJUnit4ClassRunner - SpringJUnit4ClassRunner constructor called with [class TestDemo]");
                    }
                    return true;
                }
            });
            System.out.println(start + " - " + end);
            start = end;
            end += 20000;
        }
    }
}
