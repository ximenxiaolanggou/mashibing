package center.helloworld.designpattern2023._03_builder.example_01;

public abstract class Builder {

    Bike bike = new Bike();

    /**
     * 车架
     */
    abstract void buildFrame();

    /**
     * 车座位
     */
    abstract void buildSeat();

    Bike createBike() {
        return bike;
    }
}
