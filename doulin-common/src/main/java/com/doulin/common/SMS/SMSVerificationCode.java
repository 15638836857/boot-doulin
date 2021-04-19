package com.doulin.common.SMS;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.doulin.common.j2cache.CacheUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Slf4j
public class SMSVerificationCode {

	public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
 
    //配置您申请的KEY
    public static final String APPKEY ="6ade032e5230a353f34fe505a5ed2d62";
 
    //1.屏蔽词检查测
    public static void getRequest1() {
        String result = null;
        String url = "http://v.juhe.cn/sms/black";//请求接口地址
        Map<String, Object> params = new HashMap<>();//请求参数
        params.put("word", "");//需要检测的短信内容，需要UTF8 URLENCODE
        params.put("key", APPKEY);//应用APPKEY(应用详细页查询)

        try {
            result = net(url, params, "GET");
            JSONObject object = JSONUtil.parseObj(result);
            if (object.getInt("error_code") == 0) {
                log.info(object.get("result") + "");
            } else {
                log.info(object.get("error_code") + ":" + object.get("reason"));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
 
    //2.发送短信
    public static String getRequest2(String phone,String type){
    	Random r = new Random();
    	long random =  r.nextInt(900000)+100000;
        String result =null;
        String url ="http://v.juhe.cn/sms/send";//请求接口地址
        Map<String,Object> params = new HashMap<>();//请求参数
            params.put("mobile",phone);//接收短信的手机号码
            if("1".equals(type)) {//您正在绑定手机
             params.put("tpl_id","118198");//短信模板ID，请参考个人中心短信模板设置
            }else if("2".equals(type)) {//您正在找回密码
            	params.put("tpl_id","117801");
            }else if("3".equals(type)) {//您正在进行身份认证
            	params.put("tpl_id","117794");
            }else if("4".equals(type)) {//您正在修改密码
            	params.put("tpl_id","117793");
            }else if("5".equals(type)) {//您正在注册
            	params.put("tpl_id","117792");
            }else if("6".equals(type)) {//您正在登录
            	params.put("tpl_id","117791");
            }else {//老版本
            	params.put("tpl_id","99242");
            }
            String  code = "#code#="+random;
            params.put("tpl_value",code);//变量名和变量值对。
            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
            params.put("dtype","json");//返回数据的格式,xml或json，默认json
 
        try {
            result =net(url, params, "POST");
            JSONObject object = JSONUtil.parseObj(result);
            if(object.getInt("error_code")==0){
            	String randoms = String.valueOf(CacheUtils.get("code"+phone, type));
            	if(null != randoms && randoms.length()>0 && !"null".equals(randoms)) {
            		randoms=randoms+","+random;
            	}else {
            		randoms=random+"";
            	}
            	CacheUtils.put("code"+phone,type,randoms,1800);
                return randoms;
            }else{
                log.info(object.get("error_code")+":"+object.get("reason"));
            }
            
        } catch (Exception e) {
          log.error(e.getMessage());
        }
        
        return null;
    }
    
  //2.小区店铺发送短信
    public static boolean getRequest3(String phone,String name,String count,String goods,String userPhone,String address){
        String result =null;
        String url ="http://v.juhe.cn/sms/send";//请求接口地址
        Map<String,Object> params = new HashMap<>();//请求参数
        params.put("mobile",phone);//接收短信的手机号码
        params.put("tpl_id","145079");//短信模板ID，请参考个人中心短信模板设置
        String  code = "#name#="+name+"&#count#="+count+"&#goods#="+goods+"&#phone#="+userPhone+""+"&#address#="+address;
        params.put("tpl_value",code);//变量名和变量值对。
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","json");//返回数据的格式,xml或json，默认json
 
        try {
            result =net(url, params, "POST");
            JSONObject object = JSONUtil.parseObj(result);
            if(object.getInt("error_code")==0){
            	/*System.out.println(object.get("error_code")+":"+object.get("reason"));*/
                return true;
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
    }
    
    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map<String,Object> params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                        out.writeBytes(urlencode(params));
                } catch (Exception e) {
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }
 
    //将map型转为请求参数型
    @SuppressWarnings("rawtypes")
	public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
