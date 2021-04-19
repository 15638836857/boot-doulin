package com.doulin.entity.image;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @className ImgDoConfig
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/18 22:05
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "filesdo")
@Data
public class ImgDoConfig implements Serializable {
    @Value("${filesdo.host}")
    private String host;
    @Value("${filesdo.filePath}")
    private String filePath;
    @Value("${filesdo.prefix}")
    private String prefix;
}
