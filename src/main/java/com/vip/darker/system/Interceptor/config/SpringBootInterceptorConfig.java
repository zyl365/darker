package com.vip.darker.system.Interceptor.config;

import com.vip.darker.system.Interceptor.LogInterceptor;
import com.vip.darker.system.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Darker
 * @description ：全局拦截器配置
 * @date : 2018/9/12 16:36
 */
@Configuration
public class SpringBootInterceptorConfig implements WebMvcConfigurer {

    /**
     * 功能描述: 拦截器配置
     *
     * @auther: darker
     * @date: 2018/9/12 16:47
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 日志拦截配置
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/home").addPathPatterns("/admin");
        // 登录拦截配置
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin").addPathPatterns("/admin/");
    }

    /**
     * 功能描述: 视图控制器配置
     *
     * @auther: darker
     * @date: 2018/10/27 16:08
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error/404").setViewName("/error/404");
        registry.addViewController("/error/500").setViewName("/error/500");
    }
}