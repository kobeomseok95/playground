package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    @Override
    public Object run() throws ZuulException {
        log.info("================================== printing logs: ");
//        request, response를 가져온다.
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("================================== " + request.getRequestURI());
        return null;
    }

    @Override   //사전필터, 사후필터 결정하기 사전은 pre
    public String filterType() {
        return "pre";
    }

    @Override   //해당 필터의 순서
    public int filterOrder() {
        return 1;
    }

    @Override   //필터의 사용 여부
    public boolean shouldFilter() {
        return true;
    }
}
