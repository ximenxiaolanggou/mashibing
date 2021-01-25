package top.damoncai.designattern.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg extends AbstractMsg {
    private String name;
}
