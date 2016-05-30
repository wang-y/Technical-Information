package com.wy.spring.boot.jpa.demo.dynamicdatasource.aop.aspect;

import com.wy.spring.boot.jpa.demo.dynamicdatasource.DynamicDataSourceContextHolder;
import com.wy.spring.boot.jpa.demo.dynamicdatasource.aop.annotation.TargetDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2016/5/16.
 */

@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, TargetDataSource ds) throws Throwable {
        String dsId = ds.value();
        if (!DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            //logger.error("数据源[{}]不存在，使用默认数据源 > {}", ds.value(), point.getSignature());
        } else {
            //logger.debug("Use DataSource : {} > {}", ds.name(), point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(ds.value());
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, TargetDataSource ds) {
        //logger.debug("Revert DataSource : {} > {}", ds.value(), point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
