package com.forezp.valuefilter;

import java.lang.annotation.*;

/**
 * 注解类
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldFilter {
    String type() default "";
}
