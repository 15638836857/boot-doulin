package com.doulin.common.baidu;

import cn.hutool.core.io.FileUtil;
import com.baidu.aip.util.Base64Util;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;

/**
 * @className 证件
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/22 10:56
 * @Version 1.0
 */
@Slf4j
public class OcrBaiduUtil {
    /**
     * 重要提示代码中所需工具类 银行卡
     *
     */
    public static String bankCard( String filePath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/bankcard";
        try {
            byte[] imgData = FileUtil.readBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            String accessToken = AuthService.getAuth();
            String result = HttpUtil.post(url, accessToken, param);
            return result;
        } catch (Exception e) {
            log.error("读取银行卡异常"+e.getMessage());
        }
        return null;
    }
    /**
     * 重要提示代码中所需工具类  身份证
     */
    public static String idcard(String cardPath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
        try {
            // 本地文件路径
            String filePath = cardPath;
            byte[] imgData = FileUtil.readBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "id_card_side=" + "front" + "&image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result =   HttpUtil.post(url, accessToken, param);
            return result;
        } catch (Exception e) {
            log.error("读取身份证失败"+e.getMessage());
        }
        return null;
    }
    /**
     * 重要提示代码中所需工具类
     * 下载
     */
    public static String businessLicense(String filePath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/business_license";
        try {
            // 本地文件路径
            byte[] imgData = FileUtil.readBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken =AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        System.out.println(businessLicense("D:\\card\\4.jpg"));
//    }



}
