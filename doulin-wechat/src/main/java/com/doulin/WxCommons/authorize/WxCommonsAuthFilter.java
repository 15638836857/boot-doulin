package com.doulin.WxCommons.authorize;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.doulin.entity.TUser;
import com.doulin.service.TUserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class WxCommonsAuthFilter implements Filter {
    @Autowired
    private TUserService userService;

    private StringBuffer sb;
    @Override
    public void init(FilterConfig filterConfig) {
        sb=new StringBuffer();
    }
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Pragma", "no-cache");
        res.addHeader("Cache-Control", "must-revalidate");
        res.addHeader("Cache-Control", "no-cache");
        res.addHeader("Cache-Control", "no-store");
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");
        log.info("requestUrl****" + path);
        if (path.endsWith("auth") ||
                path.endsWith("accept") ||
                path.endsWith("pay_back")||
                path.contains("swagger-ui.html")||
                path.contains("swagger")||
                path.contains("swagger-resources")||
                path.contains("webjars")||
                path.contains("csrf")||
                path.contains("v2")||
                path.contains("files")||
                StrUtil.isEmpty(path)
              ) {
            chain.doFilter(request, response);
            return;
        }
        String token=req.getHeader("token");
        if (null == token) {
            throw new Exception("用户签名信息有误");
        } else {
            String tokenStr =token;//SystemService.entryptPassword();
            if(StrUtil.isEmpty(tokenStr)){
                throw new Exception("用户签名信息有误");
            }
            String openId = tokenStr.substring(0, tokenStr.indexOf("&"));
            TUser user = userService.getByOpenidAndType(openId);
            if (null == user) {
                throw new Exception("用户签名信息有误");
            } else {
                chain.doFilter(request, response);
                return;
            }

        }
    }

    @Override
    public void destroy() {

    }

    private Map<String,Object> getBody(ServletRequest request){
        Map<String,Object> params = new HashMap<String, Object>();
        BufferedReader br;
        try {
            br = request.getReader();
            String str, wholeStr = "";
            while((str = br.readLine()) != null){
                wholeStr += str;
            }
            if(StrUtil.isNotEmpty(wholeStr)){
                JSONUtil.parseObj(wholeStr);
                params = (Map<String,Object>)JSONUtil.parseObj(wholeStr);
            }
        } catch (IOException e1) {
            log.error(""+e1);
        }
        return params;
    }
}
