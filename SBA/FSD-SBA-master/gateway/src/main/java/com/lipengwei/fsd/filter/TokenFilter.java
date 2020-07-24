package com.lipengwei.fsd.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.lipengwei.fsd.constants.SBAConstants;
import com.lipengwei.fsd.dto.UserInfoDto;
import com.lipengwei.fsd.feign.AuthFeign;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述: 过滤器 token
 **/
public class TokenFilter extends ZuulFilter {

    private final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);
    @Autowired
    private AuthFeign authFeign;

    @Override
    public String filterType() {
        return "pre"; // 可以在请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 0; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (StringUtils.equals("OPTIONS",request.getMethod())){
            return false;
        }
        String uri = request.getRequestURL().toString();
        if(uri.contains("/api/auth/register")
            || uri.contains("/api/auth/login")
            || uri.contains("/api/search")){
            return false;
        }
        return true; // 是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        LOGGER.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getHeader(SBAConstants.TOKEN_KEY);

        if (StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
            ctx.setResponseBody("token is empty");
            return null;
        }

        ResponseEntity<UserInfoDto> responseEntity = authFeign.checkToken(token);
        if(StringUtils.isBlank(responseEntity.getBody().getUsername())){
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
            ctx.setResponseBody("checkToken error");
            return null;
        }
        ctx.setSendZuulResponse(true); //对请求进行路由
        ctx.setResponseStatusCode(HttpStatus.OK.value());
        return null;
    }

}