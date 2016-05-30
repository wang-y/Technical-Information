package com.wy.spring.boot.jpa.demo.aop.annotation;

import java.lang.annotation.*;

/**
 * Created by lenovo on 2016/5/6.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SysLog {
    String value() default "";
}
