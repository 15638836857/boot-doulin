package com.doulin.admin.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.doulin.common.R;
import com.doulin.common.token.SysUserTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 目的: 过滤OPTIONS请求
 *  *      继承shiro 的form表单过滤器，对 OPTIONS 请求进行过滤。
 *  *      前后端分离项目中，由于跨域，会导致复杂请求，即会发送preflighted request，这样会导致在GET／POST等请求之前会先发一个OPTIONS请求，但OPTIONS请求并不带shiro
 *  *      的'authToken'字段（shiro的SessionId），即OPTIONS请求不能通过shiro验证，会返回未认证的信息。
 *  *
 *  * 备注说明： 需要在 shiroConfig 进行注册
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/30 17:28
 * @Version 1.0
 */
@Slf4j
public class CORSAuthenticationFilter  extends FormAuthenticationFilter {
    public CORSAuthenticationFilter() {
        super();
    }

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //Always return true if the request's method is OPTIONS
        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }
        } else {
            //解决 WebUtils.toHttp 往返回response写数据跨域问题
            HttpServletRequest req = WebUtils.toHttp(request);
            String origin = req.getHeader("Origin");
            HttpServletResponse resp = WebUtils.toHttp(response);
            resp.setHeader("Access-Control-Allow-Origin", origin);
            //通过对 Credentials 参数的设置，就可以保持跨域 Ajax 时的 Cookie
            //设置了Allow-Credentials，Allow-Origin就不能为*,需要指明具体的url域
            resp.setHeader("Access-Control-Allow-Credentials", "true");
            // 返回固定的JSON串
            WebUtils.toHttp(response).setContentType("application/json; charset=utf-8");
            String token=req.getHeader(SysUserTokenUtil.tokenHeard);
            String loginNo=req.getHeader(SysUserTokenUtil.accountNo);
            try {
                if(loginNo.equals(SysUserTokenUtil.getName(token))){
                    return true;
                }else {
                    WebUtils.toHttp(response).getWriter().print(JSONUtil.parseObj(R.error("未登录")));
                    return false;
                }
            } catch (Exception e) {
                log.error(e.getMessage());
                WebUtils.toHttp(response).getWriter().print(JSONUtil.parseObj(R.error("登录过期")));
                return false;
            }
//            String loginNo=SysUserTokenUtil.getName(token);
//            Map<String, Object> body = getBody(request);
//            log.info("body********" + body);
//            Map<String, Object> s = (Map<String, Object>) body.get(SysContent.S_STR);
//            String userid = s.get(SysContent.LOGIN_USERID).toString();
//            if(loginNo.equals(userid)){
//                return true;
//            }
//        HttpServletResponse res = (HttpServletResponse)response;
//        res.setHeader("Access-Control-Allow-Origin", "*");
//        res.setStatus(HttpServletResponse.SC_OK);
//        res.setCharacterEncoding("UTF-8");
//        PrintWriter writer = res.getWriter();
//        Map<String, Object> map= new HashMap<>();
//        map.put("code", 702);
//        map.put("msg", "未登录");
//        writer.write(JSONUtil.toJsonStr(map));
//        writer.close();
//        return false;
        }

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
