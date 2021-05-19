package com.doulin.WxCommons.authorize;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TUser;
import com.doulin.service.TUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @className WxBaseController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/17 15:59
 * @Version 1.0
 */
@Slf4j
public class WxBaseController {
    @Autowired
    private TUserService tUserService;
    /**
     * 获取 s的值
     * @param requestMap
     * @return
     */
    public Map<String,Object> getSvalue(Map<String,Object> requestMap){
        return (Map<String, Object>) requestMap.get(SysContent.S_STR);
    }
    /**
     * 获取 v 的值
     * @param requestMap
     * @return
     */
    public Map<String,Object> getVvalue(Map<String,Object> requestMap){
        return (Map<String, Object>) requestMap.get(SysContent.V_STR);
    }
    public Map<String,Object> getPageParm(Map<String,Object> requestMap){
        Map<String,Object> smap=getSvalue(requestMap);
        Map<String,Object> vmap=getVvalue(requestMap);
        vmap.putAll(smap);
        return vmap;
    }
    /**
     * 登录凭证校验
     * @param code
     * @param wxUrl
     * @return
     */
    public  String  getSmallOpenId(String code,String wxUrl) throws Exception {
        String url = wxUrl.replace("[code]", code);
        JSONObject json = null;
        try {
            URL getUrl = new URL(url);
            HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] b = new byte[size];
            is.read(b);
            String message = new String(b, "UTF-8");
            json = JSONUtil.parseObj(message);
            //成功返回的数据json包
            //openid	string	用户唯一标识
            //session_key	string	会话密钥
            //unionid	string	用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 UnionID 机制说明。
            //errcode	number	错误码
            //errmsg	string	错误信息
            String openId = json.getStr("openid");
            String session_key = json.getStr("session_key");
            String unionid = json.getStr("unionid");
            TUser user = tUserService.getByOpenidAndType(openId);
            if (null == user) {
                TUser tUser = new TUser();
                tUser.setWxOperid(openId);
                tUser.setSessionKey(session_key);
                tUser.setDelFlag(SysContent.INTGER_0);
                tUser.setStatus(SysContent.Y_STR);
                tUser.setShopFlag(SysContent.N_STR);
                tUser.setWxAccessToken(openId + "&" + session_key);

                tUserService.updateByOpenId(tUser);
            } else {
                if (SysContent.N_STR.equals(user.getStatus())) {
                    throw new Exception("该用户被禁用");
                }
            }
            return openId + "&" + session_key;
        } catch (Exception e) {
            log.error("登录凭证校验异常" + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

}
