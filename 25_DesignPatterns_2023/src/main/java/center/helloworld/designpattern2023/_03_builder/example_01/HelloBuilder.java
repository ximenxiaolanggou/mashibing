package center.helloworld.designpattern2023._03_builder.example_01;

/**
 * @author zhishun.cai
 * @create 2023/3/15
 * @note
 */
public class HelloBuilder extends Builder {
    @Override
    public void buildFrame() {
        System.out.println("哈罗不锈钢车架~~~");
    }

    @Override
    public void buildSeat() {
        System.out.println("哈罗不锈钢座位~~~");
    }
}
