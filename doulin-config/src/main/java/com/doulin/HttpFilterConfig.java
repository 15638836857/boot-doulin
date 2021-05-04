package com.doulin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @className HttpFilterConfig
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/20 14:13
 * @Version 1.0
 */
@Configuration
public class HttpFilterConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 允许任何域名使用
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        // 允许任何方法（post、get等）
        config.addAllowedMethod("*");
        // 允许任何头
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        // 对接口配置跨域设置
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }

}
