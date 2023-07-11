package center.helloworld.designpattern2023._01_observer.example_02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhishun.cai
 * @create 2023/3/9
 * @note 摇号结果封装类
 */
@Data
public class LotteryResult {

    /**
     * 摇号的用户ID
     */
    private Long userId;

    public LotteryResult(Long userId, String msg, Date datetime) {
        this.userId = userId;
        this.msg = msg;
        this.datetime = datetime;
    }

    public LotteryResult() {}

    /**
     * 摇号结果
     */
    private String msg;

    /**
     * 摇号结果时间
     */
    private Date datetime;

    @Override
    public String toString() {
        return "ID为"+ userId +
                "的用户,您" + msg + '\'' +
                ", 日期：" + datetime;
    }
}
