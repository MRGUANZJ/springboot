package com.zhijie.confing;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zhijie
 * @Date: 2020/06/16/13:25
 * @Description:
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //后台监控功能
    @Bean
    public ServletRegistrationBean StatViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登录，账号密码配置
        HashMap<String, String> initParameteras = new HashMap<>();
        //增加配置
        initParameteras.put("loginUsername","sa");
        initParameteras.put("loginPassword","123456");

        //允许谁可以访问
        initParameteras.put("allow","");

        //静止谁访问
        initParameteras.put("zhijie","129.168.0.1");


        bean.setInitParameters(initParameteras);//设置初始化参数
        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        //可以过滤哪些请求
        HashMap<Object, Object> initParameteras = new HashMap<>();
        //这些东西不统计
        initParameteras.put("exclusions","*.js,*.css,/druid/*");
        return bean;
    }

}
