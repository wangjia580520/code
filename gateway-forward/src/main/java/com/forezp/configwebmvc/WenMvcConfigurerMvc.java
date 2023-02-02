package com.forezp.configwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer 主要用途1.添加拦截器 2.消息转换 3. 跨域问题 4. 静态资源路径转换
 */
@Configuration
public class WenMvcConfigurerMvc implements WebMvcConfigurer {
    /*@Bean("configHandlerintrceptor")
    public HandlerIntrceptorMvc handlerIntrceptorMvc() {
        return new HandlerIntrceptorMvc();
    }*/
    // 和上面的bean注入二者使用其一
    @Autowired
    private HandlerIntrceptorMvc handlerIntrceptorMvc;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerIntrceptorMvc)
                .addPathPatterns("/say", "/eat")
                .excludePathPatterns("/listen");
    }
}
