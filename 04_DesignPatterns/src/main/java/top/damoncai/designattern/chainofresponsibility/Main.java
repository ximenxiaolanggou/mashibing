package top.damoncai.designattern.chainofresponsibility;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:43
 */

public class Main {
    public static void main(String[] args) {
        String msgStr = "<script>,hello 996 ~~ 0.0";
        Msg msg = new Msg();
        msg.setName("damoncai");
        msg.setMsg(msgStr);

        FilterChain chains = new FilterChain();
        chains
                .addFilter(new HtmlFilter())
                .addFilter(new SensitiveWordFilter());

        FilterChain chains2 = new FilterChain();
        chains2.addFilter(new FaceFilter());
        chains.addFilter(chains2);

        chains.doFilter(msg);

        System.out.println(msg.getMsg());

    }
}
