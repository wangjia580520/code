package com.forezp.configwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlConfigWebmvc {
    @Autowired
    private ConfigService configService;

    @RequestMapping("/say")
    public String say() {
        return configService.say();
    }

    @RequestMapping("/eat")
    public String eat() {
        return configService.eat();
    }

    @RequestMapping("/listen")
    public String listen() {
        return configService.listen();
    }
}
