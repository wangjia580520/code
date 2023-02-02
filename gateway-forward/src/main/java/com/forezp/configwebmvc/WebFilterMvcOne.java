package com.forezp.configwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器,如果有多个过滤器或者需要指定过滤地址
 * 方法一 @ServletComponentScan 启动类加上，注意此时类上没有@Conpent和@Configuration 注解
 * 方法二 采用去掉所有注解，然后使用容器注入的方式
 */
@WebFilter(urlPatterns = "/say", filterName = "webFilterMvc")
@Order(1)
public class WebFilterMvcOne implements Filter {

    @Autowired
    private ConfigService configService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("我是过滤器1" + configService.say());
        String url = request.getRequestURI();
        if ("/say".equals(url)) {
            response.sendRedirect("/eat");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
