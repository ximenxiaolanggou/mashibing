package top.damoncai.designattern.abstractfactory.c001_type;

/**
 * @author zhishun.cai
 * @date 2021/1/22 15:02
 */

public class MagicFactory extends AbastractFactory {


    @Override
    Vehicle vehicle() {
        Vehicle magicStick = new MagicStick();
        return magicStick;
    }

    @Override
    Food food() {
        Food mushRoom = new MushRoom();
        return mushRoom;
    }
}
