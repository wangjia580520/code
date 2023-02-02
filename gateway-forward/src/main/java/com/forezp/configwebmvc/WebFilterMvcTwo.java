package com.forezp.configwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器,如果有多个过滤器或者需要指定过滤地址
 * 方法一 @ServletComponentScan 启动类加上，注意此时类上没有@Conpent和@Configuration 注解
 * 方法二 去掉@ServletComponentScan 和类上的注解采，然后使用容器注入的方式
 */
public class WebFilterMvcTwo implements Filter {

    private ConfigService configService;

    public WebFilterMvcTwo(ConfigService configService) {
        this.configService = configService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("initTwo");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("我是过滤器2" + configService.say());
        String url = request.getRequestURI();
        if ("/say".equals(url)) {
            response.sendRedirect("/eat");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
