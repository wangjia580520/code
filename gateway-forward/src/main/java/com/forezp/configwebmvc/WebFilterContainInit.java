package com.forezp.configwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebFilterContainInit {
    //利用FilterRegistrationBean将filter装配为一个bean 并且通过setOrder方法去控制filter的执行顺序

    @Autowired
    private ConfigService configService;

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean<WebFilterMvcTwo> registration = new FilterRegistrationBean<>();
        registration.setFilter(new WebFilterMvcTwo(configService));
        registration.addUrlPatterns("/eat","/say");
        registration.setOrder(2); //过滤器的执行顺序
        registration.setName("MyFilterTwo");
        return registration;
    }
}
