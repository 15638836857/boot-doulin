package com.doulin.entity.shop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @className BankDo
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/7 10:24
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "bankdo")
@Data
public class BankDo implements Serializable {
    private String httpUrl;
    private String logoUrl;
}
