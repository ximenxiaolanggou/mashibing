package center.helloworld.designpattern2023._03_builder.example_02;

/**
 * @author zhishun.cai
 * @create 2023/3/15
 * @note
 */
public class Client {


    public static void main(String[] args) {
        RabbitMQClient rabbitMQClient = new RabbitMQClient.Builder()
                .setHost("127.0.0.1")
                .setPort(6379)
                .setMode(1)
                .build();


        rabbitMQClient.connect();
        rabbitMQClient.send("hello");
    }
}
