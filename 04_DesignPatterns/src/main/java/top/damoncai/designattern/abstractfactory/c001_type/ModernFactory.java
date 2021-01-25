package top.damoncai.designattern.abstractfactory.c001_type;

/**
 * @author zhishun.cai
 * @date 2021/1/22 15:00
 */

public class ModernFactory extends AbastractFactory {
    @Override
    Vehicle vehicle() {
        Vehicle car = new Car();
        return car;
    }

    @Override
    Food food() {
        Food bread = new Bread();
        return bread;
    }
}
