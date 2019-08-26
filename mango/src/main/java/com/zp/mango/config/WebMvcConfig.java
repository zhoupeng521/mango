package com.zp.mango.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @创建人 zp
 * @创建时间 2019/8/26
 * @描述 web配置（CORS跨域）
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{

    /**
     * 方式一：
     * 全局配置（CORS）
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST","GET","PUT","DELETE")
                .allowedHeaders("*")
                .maxAge(3600)
                .allowCredentials(true);
    }

    /**
     * 方式二：
     * 添加 Filter 的方式，配置 CORS 规则,手动指定对哪些接口有效
     * @return
     */
    /*@Bean
    public FilterRegistrationBean corsFilter(){
        UrlBasedCorsConfigurationSource basedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("http://localhost:8011");
        corsConfiguration.addAllowedOrigin("null");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        //CORS配置对所有接口都有效
        basedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CorsFilter(basedCorsConfigurationSource));
        return filterRegistrationBean;
    }*/

}
