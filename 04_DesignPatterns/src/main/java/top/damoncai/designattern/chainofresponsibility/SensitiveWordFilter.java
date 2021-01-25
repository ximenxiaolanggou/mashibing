package top.damoncai.designattern.chainofresponsibility;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:40
 */

public class SensitiveWordFilter implements Filter {

    @Override
    public boolean doFilter(AbstractMsg msgs) {
        String res = msgs.getMsg().replace("996", "965");
        msgs.setMsg(res);
        return false;
    }
}
