package com.doulin.config;

import com.doulin.WxCommons.authorize.WxCommonsAuthFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;

/**
 * @className WxAuthFilter
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/17 18:30
 * @Version 1.0
 */
@Order(1)
@WebFilter(filterName = "WxAuthFilter", urlPatterns = {"/wx/*"})
@Component
public class WxAuthFilter extends WxCommonsAuthFilter {
    public WxAuthFilter(){
//        type=2;
    }
}

