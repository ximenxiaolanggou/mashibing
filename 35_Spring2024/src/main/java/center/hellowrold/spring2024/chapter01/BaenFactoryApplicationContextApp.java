package center.hellowrold.spring2024.chapter01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Locale;

/**
 * @author zhishun.cai
 * @create 2024/4/16
 * @note
 */
@SpringBootApplication
public class BaenFactoryApplicationContextApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BaenFactoryApplicationContextApp.class, args);

        // 国际化演示
        System.out.println(context.getMessage("hi", null, Locale.ENGLISH));
        System.out.println(context.getMessage("hi", null, Locale.CHINESE));
        System.out.println(context.getMessage("hi", null, Locale.JAPANESE));

        // 环境
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println(environment.getProperty("java_home"));

        // 发布事件
        context.publishEvent(new UserRegisterEvent(context));
    }
}
