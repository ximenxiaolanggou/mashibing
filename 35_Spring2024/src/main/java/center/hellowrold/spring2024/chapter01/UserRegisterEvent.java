package center.hellowrold.spring2024.chapter01;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author zhishun.cai
 * @create 2024/4/16
 * @note
 */
//@Component
public class UserRegisterEvent extends ApplicationEvent {

    public UserRegisterEvent(Object source) {
        super(source);
    }
}
