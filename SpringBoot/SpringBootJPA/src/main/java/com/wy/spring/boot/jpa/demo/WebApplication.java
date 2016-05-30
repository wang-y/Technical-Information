package com.wy.spring.boot.jpa.demo;

import com.wy.spring.boot.jpa.demo.dynamicdatasource.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Created by lenovo on 2016/5/4.
 */
@SpringBootApplication
@ServletComponentScan
@Import({DynamicDataSourceRegister.class})
public class WebApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WebApplication.class, args);
    }
}
