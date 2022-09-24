package com.forezp;

import com.forezp.config.ApplicationInfo;
import com.forezp.entity.LogOut;
import com.forezp.service.RequestAbstractService;
import com.forezp.service.RequestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.forezp.*"})
@RestController
public class

HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    @LogOut
    @GetMapping("/abstract/{code}")
    public String abstractMethod(@PathVariable String code) {
        RequestAbstractService service = (RequestAbstractService) ApplicationInfo.relationAbstractMap.get(code);
        return service.invoke();
    }
    @LogOut
    @GetMapping("/interface/{code}")
    public String interfaceMethod(@PathVariable String code) {
        RequestService service = (RequestService) ApplicationInfo.relationInterFaceMap.get(code);
        return service.invoke();
    }
}
