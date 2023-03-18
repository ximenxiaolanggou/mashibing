package center.helloworld.designpattern2023._03_builder.example_01;

/**
 * @author zhishun.cai
 * @create 2023/3/15
 * @note
 */
public class MoBaiBuilder extends Builder {
    @Override
    public void buildFrame() {
        System.out.println("摩拜碳纤维车架~~~");
    }

    @Override
    public void buildSeat() {
        System.out.println("摩拜碳纤维座位~~~");
    }
}
