package top.damoncai.designattern.chainofresponsibility.servlet;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:39
 */

public interface Filter {

    boolean doFilter(Request request,Response response, FilterChain filterChain);
}
