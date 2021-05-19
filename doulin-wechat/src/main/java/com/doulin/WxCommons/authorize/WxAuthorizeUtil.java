package com.doulin.WxCommons.authorize;


import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class WxAuthorizeUtil {

    /**
     * 签名
     * @param response
     * @param appid
     * @param backUrl
     * @param redUrl
     * @throws Exception
     */
    public static void auth2(HttpServletResponse response, String appid, String backUrl, String redUrl) throws Exception {
        if(redUrl==null) {
            redUrl="";
        }
        String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+
                "&redirect_uri="+URLEncoder.encode(backUrl+"?redUrl="+redUrl,"UTF-8")+
                "&response_type=code"+
                "&scope=snsapi_userinfo"+
                "&state=STATE&connect_redirect=1#wechat_redirect";
        response.sendRedirect(url);
    }
}
