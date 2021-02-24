package top.damoncai.designattern.prototype.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhishun.cai
 * @date 2021/1/28 14:02
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable {

    private String name;

    private Integer age;

    private Location loc;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
