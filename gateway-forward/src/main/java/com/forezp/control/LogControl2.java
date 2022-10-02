package com.forezp.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志按照业务输出到不同文件中
 */
@RestController
public class LogControl2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogControl2.class);
    private static final Marker COLLECTED_MARKER1 = MarkerFactory.getMarker("type1");
    private static final Marker COLLECTED_MARKER2 = MarkerFactory.getMarker("type2");

    @GetMapping("log3")
    public String helloLog() {
        LOGGER.info(COLLECTED_MARKER1,"我是log3");
        return "123";
    }

    @GetMapping("log4")
    public String helloLog2() {
        LOGGER.error(COLLECTED_MARKER2,"我是log4");
        return "456";
    }
}
