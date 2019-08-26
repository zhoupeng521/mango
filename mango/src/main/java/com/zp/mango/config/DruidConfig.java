package com.zp.mango.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @创建人 zp
 * @创建时间 2019/8/26
 * @描述 druid连接池配置类
 */
@Configuration
public class DruidConfig {

    /**
     * servlet注册
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //ip白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //ip黑名单，如果allow于deny同时存在时，deny优先于allow
        servletRegistrationBean.addInitParameter("deny","192.168.0.19");
        //设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否可以重复密码
        servletRegistrationBean.addInitParameter("resetEnalbe","false");
        return servletRegistrationBean;
    }

    /**
     * Filter过滤
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器的过滤路径
        filterRegistrationBean.addUrlPatterns("/");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
