package com.forezp.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ListenerControl {
    @Resource
    ApplicationContext context;

    @RequestMapping("/listener")
    public String sayHelloListener() {
        context.publishEvent(new EventEntity("我是对象source", "1"));
        return "sucess";
    }
}
