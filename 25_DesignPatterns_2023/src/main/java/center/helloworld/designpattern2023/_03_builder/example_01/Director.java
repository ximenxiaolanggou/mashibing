package center.helloworld.designpattern2023._03_builder.example_01;

/**
 * @author zhishun.cai
 * @create 2023/3/15
 * @note
 */
public class Director {

    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }


    public Bike createBuilder() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
