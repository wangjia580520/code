package com.forezp.configwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器,注意在拦截器中使用接口，需要在WebMvcConfigurer里面延时加载拦截器类
 */
@Component
@Order(1)
public class HandlerIntrceptorMvc implements HandlerInterceptor {
    @Autowired
    private ConfigService configService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("我是拦截器" + configService.say());
        return true;
    }
}
