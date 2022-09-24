package com.forezp.config;

import com.forezp.service.RequestAbstractService;
import com.forezp.service.RequestService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ApplicationInfo implements ApplicationContextAware {
    public static Map<String, RequestService> relationInterFaceMap = new HashMap<>();
    public static Map<String, Object> relationAbstractMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        relationInterFaceMap.clear();
        relationAbstractMap.clear();
        Map<String, RequestService> interfacesMap = applicationContext.getBeansOfType(RequestService.class);
        Map<String, RequestAbstractService> abstractMap = applicationContext.getBeansOfType(RequestAbstractService.class);
        relationInterFaceMap.putAll(interfacesMap);
        relationAbstractMap.putAll(abstractMap);
    }
}
