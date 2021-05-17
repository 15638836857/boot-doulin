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
    //图片路径 ip
    @Value("${filesdo.host}")
    private String host;
    /**
     * 文件真实路径
     */
    @Value("${filesdo.filePath}")
    private String filePath;
    /**
     * 文件路径前缀
     */
    @Value("${filesdo.prefix}")
    private String prefix;
}
