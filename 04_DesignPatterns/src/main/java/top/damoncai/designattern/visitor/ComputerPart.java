package top.damoncai.designattern.visitor;

/**
 * @author zhishun.cai
 * @date 2021/1/26 17:43
 * @note
 */

public interface ComputerPart {

    void accept(ComputerPartVisitor computerPartVisitor);
}
