package center.helloworld.designpattern2023._03_builder.example_02;

import lombok.ToString;

/**
 * @author zhishun.cai
 * @create 2023/3/15
 * @note
 */
public class RabbitMQClient {

    private Builder builder;

    private RabbitMQClient(Builder builder) {
        this.builder = builder;
    }

    /**
     * 连接
     */
    public void connect(){
        System.out.println("开始连接：" + builder.toString());
    }

    public void send(String msg){
        System.out.println("发送消息：" + msg + "，" + builder.toString());
    }


    @ToString
    public static class Builder {
        //属性密闭性,保证对象不可变
        private String host = "127.0.0.1";
        private int port = 5672;
        private int mode;

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setMode(int mode) {
            this.mode = mode;
            return this;
        }

        public RabbitMQClient build() {
            return new RabbitMQClient(this);
        }
    }
}
