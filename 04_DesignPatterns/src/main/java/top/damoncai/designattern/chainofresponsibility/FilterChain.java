package top.damoncai.designattern.chainofresponsibility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:44
 */

public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }

    public boolean doFilter(AbstractMsg msgs){
        for (Filter filter : filters) {
            boolean stop = filter.doFilter(msgs);
            if(!stop) return false;
        }
        return true;
    }
}
