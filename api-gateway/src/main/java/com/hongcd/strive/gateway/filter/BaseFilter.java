package com.hongcd.strive.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseFilter extends ZuulFilter {
    protected static final String PRE = "pre";

    /**
     * 获取Request
     * @return
     */
    protected HttpServletRequest getRequest() {
        return RequestContext.getCurrentContext().getRequest();
    }
}