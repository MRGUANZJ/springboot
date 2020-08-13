package com.zhijie.confing;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zhijie
 * @Date: 2020/06/14/15:04
 * @Description:
 */

/**
 * 官方推荐  扩展springmvc   @EnableWebMvc
 */
//视图跳转
@Configuration
 //导入一个类DelegatingWebMvcConfiguration:从容器中获取所有的webmvcconfig
public class MyMvcConfig2 implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login"
                ,"/css/**","/js/**","/img/**");
    }
}
