package com.doulin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @className 微信端
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/17 11:04
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.doulin"})
@MapperScan(basePackages = {"com.doulin.mapper"})
@ServletComponentScan
public class WxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class, args);
    }
}
