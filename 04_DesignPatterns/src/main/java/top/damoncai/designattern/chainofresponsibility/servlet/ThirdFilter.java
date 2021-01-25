package top.damoncai.designattern.chainofresponsibility.servlet;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:40
 */

public class ThirdFilter implements Filter {

    @Override
    public boolean doFilter(Request request,Response response, FilterChain filterChain) {
        System.out.println("request third");
        filterChain.doFilter(request,response);
        System.out.println("response third");
        return true;
    }
}
