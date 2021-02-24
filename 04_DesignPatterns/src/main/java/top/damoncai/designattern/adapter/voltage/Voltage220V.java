package top.damoncai.designattern.adapter.voltage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhishun.cai
 * @date 2021/1/27 14:04
 */

@Getter
@Setter
public class Voltage220V extends Voltage {

    Integer voltage = 220;

    @Override
    public void output() {
        System.out.println("输出220V电压");
    }
}
