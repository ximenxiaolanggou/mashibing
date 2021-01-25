package top.damoncai.designattern.chainofresponsibility;

import com.sun.deploy.util.StringUtils;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:40
 */

public class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(AbstractMsg mgs) {
        String res = mgs.getMsg().replace("<", "[").replace(">", "]");
        mgs.setMsg(res);
        return true;
    }
}
