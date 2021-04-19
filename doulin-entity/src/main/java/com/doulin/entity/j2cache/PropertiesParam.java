package com.doulin.entity.j2cache;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @className PropertiesParam
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/16 16:27
 * @Version 1.0
 */
@Component
@Data
@ToString
public class PropertiesParam implements Serializable {
    @Value("${cache.broadcast}")
    private String broadcast;
    @Value("${cache.L1.provider_class}")
    private String providerClassL1;
    @Value("${cache.L2.provider_class}")
    private String providerClassL12;
    @Value("${cache.serialization}")
    private String serialization;
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    @Value("${redis.timeout}")
    private Integer timeout;
    @Value("${redis.policy}")
    private String policy;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.database}")
    private Integer database;
    @Value("${redis.namespace}")
    private String namespace;
    @Value("${redis.channel_name}")
    private String channel_name;
    @Value("${redis.maxTotal}")
    private Integer maxTotal;
    @Value("${redis.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.maxWaitMillis}")
    private String maxWaitMillis;
    @Value("${redis.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${redis.minIdle}")
    private Integer minIdle;
    @Value("${redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;
    @Value("${redis.lifo}")
    private Boolean lifo;
    @Value("${redis.softMinEvictableIdleTimeMillis}")
    private Integer softMinEvictableIdleTimeMillis;
    @Value("${redis.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${redis.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${redis.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${redis.timeBetweenEvictionRunsMillis}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${redis.blockWhenExhausted}")
    private String blockWhenExhausted;
    @Value("${ehcache.name}")
    private String name;
    @Value("${ehcache.configXml}")
    private String configXml;

}
