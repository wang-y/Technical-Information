package com.wy.spring.boot.jpa.demo.dynamicdatasource.aop.annotation;

import java.lang.annotation.*;

/**
 * Created by lenovo on 2016/5/16.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
