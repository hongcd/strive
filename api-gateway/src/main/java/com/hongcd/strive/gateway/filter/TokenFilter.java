package com.hongcd.strive.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hongcd.strive.common.utils.JsonUtils;
import com.hongcd.strive.common.utils.Response;
import com.netflix.zuul.context.RequestContext;

import java.util.Objects;

/**
 * @author HongD
 */
public class TokenFilter extends BaseFilter {

    @Override
    public String filterType() {
        return PRE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String token = ctx.getRequest().getHeader("token");
        if (!Objects.equals(token, "123456")) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.addZuulResponseHeader("content-type", "application/json;charset=utf-8");
            try {
                ctx.setResponseBody(JsonUtils.obj2Json(new Response<>(Response.FAIL, "非法访问")));
            } catch (JsonProcessingException ignore) {}
        }
        return null;
    }
}
