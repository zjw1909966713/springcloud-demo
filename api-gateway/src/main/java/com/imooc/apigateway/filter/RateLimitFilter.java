package com.imooc.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.imooc.apigateway.exception.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author 张进文
 * @ClassName RateLimitFilter
 * @Description 限流
 * @Date 2019/4/4 11:48
 * @Version 1.0
 */
@Component
public class RateLimitFilter extends ZuulFilter {

    private static final RateLimiter  RATE_LIMITER=RateLimiter.create(100);
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        //如果没有拿到令牌
       if(! RATE_LIMITER.tryAcquire()){
           throw  new RateLimitException();

       }

        return null;
    }
}
