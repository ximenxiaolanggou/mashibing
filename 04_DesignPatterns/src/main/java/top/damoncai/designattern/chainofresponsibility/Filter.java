package top.damoncai.designattern.chainofresponsibility;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:39
 */

public interface Filter {

    boolean doFilter(AbstractMsg mgs);
}
