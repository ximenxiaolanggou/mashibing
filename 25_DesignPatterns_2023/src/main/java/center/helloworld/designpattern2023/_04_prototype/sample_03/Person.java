package center.helloworld.designpattern2023._04_prototype.sample_03;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhishun.cai
 * @create 2023/3/27
 * @note
 */
@Data
public class Person implements Serializable {

    private String name;

    private Integer age;
}
