package com.study.spring.cloud.zuul.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 所有请求
 *
 * 在主类中将该过滤器加入Bean容器
 */

public class ServiceFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ServiceFilter.class);

    /**
     * 过滤器的类型，pre表示请求在路由之前被过滤
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     * 顺序，数字越大表示优先级越低，越后执行。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        final String authorization = request.getHeader("Authorization");
        logger.info("Authorization token is {}",authorization);


        final String token = request.getParameter("token");
        if(token == null){
            /**
             * 过滤器的本质就是根据过滤的规则是去判断是否将请求发到对应的服务上
             * 比如下述代码，当token不存在时，就自行处理该次请求。
             */
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            final HttpServletResponse response = requestContext.getResponse();
            response.setContentType("text/html;charset=utf-8");
            try {
                response.getWriter().write("非法请求");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
