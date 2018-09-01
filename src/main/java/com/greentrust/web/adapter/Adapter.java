package com.greentrust.web.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description:
 * @author:Yangk.
 * @create:2018-04-04 15:25
 */

@Configuration
public class Adapter extends WebMvcConfigurationSupport {

    /**
     * 显示定义拦截器对应的bean
     **/
    @Bean
    public UserInterceptor getUserInterceptor() {
        return new UserInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(getUserInterceptor()).addPathPatterns("/user/**/**").excludePathPatterns("/user/login","/user/regist");
    }
}
