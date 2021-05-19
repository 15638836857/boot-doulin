package com.doulin.WxCommons.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Map;

public class WeChatUtil {


//    private static String tokenUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
//    private static String apiTicketUrl="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

//    public static String getAccessToken(String appid,String appSecret){
//        String url=tokenUrl.replace("APPID",appid);
//        url=url.replace("APPSECRET",appSecret);
//        JSONObject jsonObj=HttpUtil.doGet(url);
//        return jsonObj.getString("access_token");
//    }
//    public static String getApiTicket(String accessToken){
//        String url=apiTicketUrl.replace("ACCESS_TOKEN",accessToken);
//        JSONObject jsonObj=HttpUtil.doGet(url);
//        return jsonObj.getString("ticket");
//    }
    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    public static String getSignature(HttpServletRequest request, String ticket, String nonce, String timestamp, String serverName){
        String  currentUrl=serverName+request.getRequestURI();
        Enumeration<String> enumeration=request.getParameterNames();
        Map<String, String[]> parameterMap=request.getParameterMap();
        while (enumeration.hasMoreElements()){
            String paramName=enumeration.nextElement();
            String [] paramValues=parameterMap.get(paramName);
            for(int i=0;i<paramValues.length;i++){
                currentUrl+="&"+paramName+"="+paramValues[i];
            }
        }
        currentUrl=currentUrl.replaceFirst("&","?");
        String string1 = "jsapi_ticket=" + ticket +
                "&noncestr=" + nonce +
                "&timestamp=" + timestamp +
                "&url=" + currentUrl;
        String signature="";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = WeChatUtil.byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return signature;
    }
}
