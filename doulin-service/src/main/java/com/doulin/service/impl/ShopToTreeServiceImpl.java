package com.doulin.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.image.ImgDoConfig;
import com.doulin.entity.shop.ShopImport;
import com.doulin.entity.shop.SykUtil;
import com.doulin.service.ShopToTreeService;
import com.doulin.service.TShopHomeBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @className ShopToTreeServiceImpl
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/26 16:26
 * @Version 1.0
 */
@Service
@Slf4j
public class ShopToTreeServiceImpl implements ShopToTreeService {

    @Autowired
    private SykUtil sykUtil;
    @Autowired
    private TShopHomeBaseInfoService shopHomeBaseInfoService;
    @Autowired
    private ImgDoConfig imgDoConfig;

    @Transactional
    @Override
    public String operToSykAddOrUpdate(TShopHomeBaseInfo shopHomeBaseInfo,TShopHomeBaseInfo dbInfo, String cmd, String oper) throws Exception {
        shopHomeBaseInfo.setPlatId(sykUtil.getPlatId());
        String param = ShopImport.getParamAddOrUpdate(shopHomeBaseInfo,dbInfo, cmd, sykUtil,oper);
        String url = sykUtil.getHttpUrl() ;
        String result = HttpUtil.post(url, param);
        JSONObject jsonObject = JSONUtil.parseObj(result);
         String resultStr= jsonObject.getStr(SysContent.RESULT);
         String msg=jsonObject.getStr(SysContent.MSG_STR);
        if (SysContent.STR_200.equals(resultStr) && SysContent.SUCCESS.equals(msg)) {
            String upjson = getParamMchCertUpload(shopHomeBaseInfo);
            JSONObject object = JSONUtil.parseObj(upjson);
            if (SysContent.STR_200.equals(object.getStr(SysContent.RESULT)) && SysContent.SUCCESS.equals(object.getStr(SysContent.MSG_STR))) {
                return SysContent.OK_STR;
            } else {
                throw new Exception(object.getStr(SysContent.MSG_STR));
            }
        } else {
            throw new Exception(jsonObject.getStr(SysContent.MSG_STR));
        }
    }

    @Override
    public String getParamMchCertUpload(TShopHomeBaseInfo shopHomeBaseInfo) throws UnsupportedEncodingException {
        TShopHomeBaseInfo db=shopHomeBaseInfoService.getInfoByLoginNo(shopHomeBaseInfo.getLoginNo());
        String param = ShopImport.getParamMchCertUpload(shopHomeBaseInfo, db,imgDoConfig,sykUtil.getApiKey());
        log.info("商家上传param"+param);
        String url = sykUtil.getHttpUrl();
        log.info("商家上传url"+url);
        String result = HttpUtil.post(url,  param);
        log.info("商家上传result"+result);
        return result;
    }

    @Override
    public Map<String,Object> qrcode(int oper, String sykQrCodeId, String merSn) throws Exception {
        String url = sykUtil.getQrcodeAddOrUpdateUrl() ;
        String planId=sykUtil.getPlatId(), apiKey=sykUtil.getApiKey();
        String param = ShopImport.qrcode(planId,oper,sykQrCodeId,merSn,apiKey);
        String result = HttpUtil.post(url, param);
        //{"result":"100","data":{"detail_error_code":"","detail_error_des":"","sn":"BBN286L60","ImgUrl":"a.xfpay.cn/Qrcode/20/BBN286L60.jpg"}}
        JSONObject jsonObject = JSONUtil.parseObj(result);
        JSONObject data=jsonObject.getJSONObject(SysContent.DATA_STR);
        if(SysContent.STR_100.equals(jsonObject.getStr(SysContent.RESULT))){
          throw new Exception(data.getStr("detail_error_des"));
        }
        return (Map<String,Object>)data;
    }
}
