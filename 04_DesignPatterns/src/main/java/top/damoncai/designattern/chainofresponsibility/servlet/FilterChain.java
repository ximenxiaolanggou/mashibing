package top.damoncai.designattern.chainofresponsibility.servlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/1/23 21:44
 */

public class FilterChain {

    private int index = 0;

    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }

    public List<Filter> getFilters(){
        return filters;
    }

    public void doFilter(Request request,Response response){
        if(filters.size() == index) return;
        Filter filter = filters.get(index);
        index ++;
        filter.doFilter(request,response,this);
    }
}
