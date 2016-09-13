package com.bm.config;

import com.bm.filter.SystemLoginFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2016/9/13.
 */
@Configuration
public class SystemConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        SystemLoginFilter systemLoginFilter = new SystemLoginFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(systemLoginFilter);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/admin/*");
        return filterRegistrationBean;
    }
}
