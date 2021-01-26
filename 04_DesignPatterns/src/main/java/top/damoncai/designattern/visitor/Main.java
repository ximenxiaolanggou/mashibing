package top.damoncai.designattern.visitor;

/**
 * @author zhishun.cai
 * @date 2021/1/26 18:06
 */

public class Main {

    public static void main(String[] args) {
        ComputerPartVisitor visitor = new PersonalComputerPartVisitor();
        ComputerPart computerPart = new Computer();
        computerPart.accept(visitor);
    }
}
