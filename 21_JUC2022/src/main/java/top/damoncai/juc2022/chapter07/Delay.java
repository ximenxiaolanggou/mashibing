package top.damoncai.juc2022.chapter07;

import lombok.Data;
import lombok.ToString;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Data
@ToString
public class Delay implements Delayed {

    private String name;

    private long time;

    public Delay(String name, Long time) {
        this.name = name;
        this.time = System.currentTimeMillis() + time;
    }

    /**
     * 返回值为 0 或者 小于0 代表延迟时间到
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.time, TimeUnit.NANOSECONDS) - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)(this.time - ((Delay) o).getTime());
    }
}
