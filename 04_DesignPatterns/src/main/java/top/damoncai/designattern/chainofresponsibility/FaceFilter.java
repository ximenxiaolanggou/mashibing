package top.damoncai.designattern.chainofresponsibility;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:40
 */

public class FaceFilter implements Filter {

    @Override
    public boolean doFilter(AbstractMsg msgs) {
        String res = msgs.getMsg().replace("0.0", "^.^");
        msgs.setMsg(res);
        return true;
    }
}
