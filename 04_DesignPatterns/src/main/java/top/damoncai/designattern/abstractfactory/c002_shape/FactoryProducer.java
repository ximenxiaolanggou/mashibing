package top.damoncai.designattern.abstractfactory.c002_shape;

/**
 * @author zhishun.cai
 * @date 2021/1/22 15:24
 */

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
