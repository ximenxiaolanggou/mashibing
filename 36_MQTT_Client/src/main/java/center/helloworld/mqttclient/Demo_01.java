package center.helloworld.mqttclient;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author zhishun.cai
 * @create 2024/5/6
 * @note
 */
public class Demo_01 {


    public static void main(String[] args) throws Exception {
        String topic = "test/topic";
        String content = "Hello World";
        int qos = 2;
        String broker = "tcp://127.0.0.1:1883";
        String clientId = "62e78509e4b078f1a8733354";
        // 持久化
        MemoryPersistence persistence = new MemoryPersistence();
        // MQTT 连接选项
        MqttConnectOptions connOpts = new MqttConnectOptions();
        // 设置认证信息
        connOpts.setUserName("62e78509e4b078f1a8733355");
        connOpts.setPassword("3hr7uixkca".toCharArray());



        MqttClient client = new MqttClient(broker, clientId, persistence);
        // 设置回调
        client.setCallback(new SampleCallback());
        // 建立连接
        System.out.println("Connecting to broker: " + broker);
        client.connect(connOpts);
        System.out.println("Connected to broker: " + broker);
    }
}

class SampleCallback implements MqttCallback {
    // 连接丢失
    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("connection lost：" + cause.getMessage());
    }

    //  收到消息
    @Override
    public void messageArrived(String topic, MqttMessage message) {
        System.out.println("Received message: \n  topic：" + topic + "\n  Qos：" + message.getQos() + "\n  payload：" + new String(message.getPayload()));
    }

    // 消息传递成功
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete");
    }
}
