package com.doulin.WxCommons.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class AuthUtil {
//    public static final String APPID="wx221280a40986c5e5";
//    public static final String APPSECRET="oxDUnQrRt8JCwkok855tMu2JACb1pArrNneVdEf3g9m";
    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject=null;
        DefaultHttpClient defaultHttpClient=new DefaultHttpClient();
        HttpGet httpGet=new HttpGet(url);
        HttpResponse httpResponse = defaultHttpClient.execute(httpGet);
        HttpEntity httpEntity=httpResponse.getEntity();
        if(httpEntity!=null){
            String result= EntityUtils.toString(httpEntity,"UTF-8");
            jsonObject= JSONObject.parseObject(result);
            //System.out.println("jsonObject:  "+jsonObject);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }


}