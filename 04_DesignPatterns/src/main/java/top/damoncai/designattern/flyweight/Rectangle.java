package top.damoncai.designattern.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhishun.cai
 * @date 2021/1/25 13:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rectangle implements Shape {

    private String color;

    private int x;

    private int y;


    @Override
    public void draw() {
        System.out.println("颜色：" + color + " X：" + x + ", Y：" + y);
    }

}
