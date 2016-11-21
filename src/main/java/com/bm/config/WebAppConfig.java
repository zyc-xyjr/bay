package com.bm.config;

import com.bm.filter.JsonpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2016/11/20.
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置拦截器
     * @author lance
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JsonpInterceptor()).addPathPatterns("/sss");
    }
}
