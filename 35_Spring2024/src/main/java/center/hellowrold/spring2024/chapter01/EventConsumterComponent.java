package center.hellowrold.spring2024.chapter01;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zhishun.cai
 * @create 2024/4/16
 * @note
 */
@Component
public class EventConsumterComponent {

    @EventListener
    public void event(UserRegisterEvent userRegisterEvent) {
        System.out.println("UserRegisterEvent");
    }
}
