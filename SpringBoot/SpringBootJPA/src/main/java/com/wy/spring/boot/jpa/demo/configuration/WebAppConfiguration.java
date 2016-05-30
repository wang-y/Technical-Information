package com.wy.spring.boot.jpa.demo.configuration;

import com.wy.spring.boot.jpa.demo.filter.AuthFilter;
import com.wy.spring.boot.jpa.demo.listener.MyListener;
import com.wy.spring.boot.jpa.demo.servlet.MyServlet;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

/**
 * Created by lenovo on 2016/5/10.
 */
@Configuration
public class WebAppConfiguration {
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Bean
    public FilterRegistrationBean authFilterRegistrationBean() {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new AuthFilter());
        frb.setEnabled(true);
        frb.addUrlPatterns("/*");
        return frb;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> myListenerRegistrationBean() {
        ServletListenerRegistrationBean slrb = new ServletListenerRegistrationBean();
        slrb.setListener(new MyListener());
        slrb.setEnabled(true);
        slrb.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return slrb;
    }

    @Bean
    public ServletRegistrationBean myServletRegistrationBean() {
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setEnabled(true);
        srb.setLoadOnStartup(1);
        srb.setServlet(new MyServlet());
        srb.addUrlMappings("/my");
        return srb;
    }

    /**
     * 配置sessionFactory   供非JPA注解方式的Dao使用
     *
     * @return
     */
    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

}
