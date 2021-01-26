package top.damoncai.designattern.flyweight;


/**
 * @author zhishun.cai
 * @date 2021/1/25 13:54
 */

public class Main {
    public static final String[] colors = {"Green","Blue","Pink","Yellow","Gray"};

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        for (int i = 0 ; i < 10 ; i ++) {
            Shape shape = factory.getShape(colors[(int)(Math.random()*5 )]);
            System.out.println(shape);
        }
    }
}
