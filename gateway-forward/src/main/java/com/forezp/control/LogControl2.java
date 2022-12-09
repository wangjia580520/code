package com.forezp.control;

import org.slf4j.*;
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
        // mdc 里面的key 在log4j3的日志输出格式里面，必须唯一对应
        MDC.put("traceId", "我是交易id1");
        LOGGER.info(COLLECTED_MARKER1,"我是log3");
        return "log3";
    }

    @GetMapping("log4")
    public String helloLog2() {
        MDC.put("traceId", "我是交易id2");
        LOGGER.error(COLLECTED_MARKER2,"我是log4");
        LOGGER.error(COLLECTED_MARKER2,"我是log4.1");
        return "log4";
    }
}
