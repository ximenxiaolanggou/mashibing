package top.damoncai.designattern.chainofresponsibility.servlet;

import java.awt.image.RescaleOp;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:43
 */

public class Main {
    public static void main(String[] args) {
        String msgStr = "";
        Request request = new Request();
        Response response = new Response();

        request.setMsg("request");
        response.setMsg("response");

        FilterChain filterChain = new FilterChain();
        filterChain
                .addFilter(new FirstFilter())
                .addFilter(new SecondFilter())
                .addFilter(new ThirdFilter());


        filterChain.doFilter(request,response);

    }
}
