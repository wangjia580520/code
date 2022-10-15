package com.forezp.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志按照类型输出到不同文件中
 */
@RestController
public class LogControl {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogControl.class);

    @GetMapping("log1")
    public String helloLog() {
        LOGGER.info("我是log1");
        MDC.put("MDC1","MDC1");
        return "123";
    }

    @GetMapping("log2")
    public String helloLog2() {
        LOGGER.error("我是log2");
        MDC.put("MDC2","MDC2");
        return "456";
    }
}
