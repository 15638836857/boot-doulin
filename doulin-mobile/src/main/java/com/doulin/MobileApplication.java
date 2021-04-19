package com.doulin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @className MobileApplication
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/16 8:18
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.doulin"})
@MapperScan(basePackages = {"com.doulin.mapper"})
public class MobileApplication {
    public static void main(String[] args) {
        SpringApplication.run(MobileApplication.class, args);
    }
}
