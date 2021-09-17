import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import top.damoncai.kafka.App;

import java.util.Arrays;
import java.util.List;

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
    @Transactional
    public void produceCycle() {
        template.send("topic-curve-cycle","IOT-SN01","value - cycle");
    }

    @org.junit.Test
    @Transactional
    public void produceSensor() throws JSONException {

        for (int i = 0; i < 100; i++) {
            JSONObject obj = new JSONObject();
            obj.put("name", i);
            System.out.println(" hello " + i);
            ListenableFuture<SendResult<String, String>> send = template.send("topic-curve-sensor", "IOT-SN02", "value - sensor");
            send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    // TODO 更新数据发送状态
                    System.out.println("onFailure");
                }
                @SneakyThrows
                @Override
                public void onSuccess(SendResult<String, String> stringStringSendResult) {
                    // TODO 更新数据发送状态
                    Thread.sleep(500);
                    System.out.println("onSuccess：" + obj.get("name"));
                }
            });
        }
    }

    @org.junit.Test
    @Transactional
    public void produceCycleAndSensor() {
        template.send("topic-curve-cycle","IOT-SN01","value - cycle");
        template.send("topic-curve-sensor","IOT-SN02","value - sensor");
    }

    @org.junit.Test
    @Transactional
    public void topic02() {
        template.send("topic02","key1","value - cycle1");
        template.send("topic02","key1","value - cycle2");
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
                //Cycle
                kafkaOperations.send(new ProducerRecord("topic05",0,"key" ,"value transaction1"));
                // 6 Sensor
                kafkaOperations.send(new ProducerRecord("topic05",0,"key","value transaction1"));
                // EO
                kafkaOperations.send(new ProducerRecord("topic05",0,"key","value transaction1"));
                return true;
            }
        });
    }
}
