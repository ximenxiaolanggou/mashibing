package top.damoncai.designattern.abstractfactory.c001_type;

/**
 * @author zhishun.cai
 * @date 2021/1/22 15:03
 */

public class Main {

    public static void main(String[] args) {
        AbastractFactory modernFactory = new MagicFactory();
        modernFactory.food().printName();
        modernFactory.vehicle().go();
    }
}
