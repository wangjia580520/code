package com.forezp.config;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopLogOutInfo {
    @Pointcut(value = "@annotation(com.forezp.entity.LogOut)")
    public void logoutMethod() {
    }

    @Around("logoutMethod()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] params = joinPoint.getArgs();
        // 打印或者校验参数
        System.out.print(JSONObject.toJSONString(params));
        return joinPoint.proceed();
    }
}
