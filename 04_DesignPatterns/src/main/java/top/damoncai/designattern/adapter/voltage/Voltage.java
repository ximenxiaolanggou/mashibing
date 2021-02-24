package top.damoncai.designattern.adapter.voltage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhishun.cai
 * @date 2021/1/27 14:05
 * @note
 */

@Getter
@Setter
public abstract class Voltage {

    Integer voltage;

    abstract void output();

}
