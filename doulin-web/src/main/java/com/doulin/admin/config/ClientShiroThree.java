package com.doulin.admin.config;

import com.doulin.common.token.SysUserTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className ClientShiroThree
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/24 16:33
 * @Version 1.0
 */
@Slf4j
public class ClientShiroThree extends AuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse response1) throws Exception {
        HttpServletResponse response = (HttpServletResponse) response1;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ajax = request.getHeader("x-requested-with");
        if (null == ajax) {
            log.error("=====不是ajax");
            return false;
        } else {
            log.info("=====是ajax" + ajax);
//            response.setContentType("text/html;charset=utf-8");
////            response.getWriter().write("访问有问题");
            return true;
        }
//        return false;
    }
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse response, Object mappedValue) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(SysUserTokenUtil.tokenHeard);
        log.info("================"+token);
        if (null == token||"".equals(token)) {
            System.out.println("-------------------token为空");
            return false;
        }
        //验证token的真实性
        try {
            SysUserTokenUtil.getTokenBody(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("----------------token有问题");
            return false;
        }
        return true;
    }
}
