package top.damoncai.designattern.strategy.c_001comparable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhishun.cai
 * @date 2021/1/21 17:46
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cat implements Comparable<Cat> {

    private String name;

    private Integer age;

    @Override
    public int compareTo(Cat cat) {
        if(this.age < cat.getAge()) return -1;
        if(this.age > cat.getAge()) return 1;
        else return 0;
    }
}
