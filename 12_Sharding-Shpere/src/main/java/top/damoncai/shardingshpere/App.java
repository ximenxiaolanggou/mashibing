package top.damoncai.shardingshpere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhishun.cai
 * @date 2021/4/16 13:55
 */

@SpringBootApplication
@MapperScan("top.damoncai.shardingshpere.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
