package com.doulin.entity.shop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @className 商云客
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/26 16:40
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "sykes")
@Data
public class SykUtil implements Serializable {
    private String httpUrl;
}
