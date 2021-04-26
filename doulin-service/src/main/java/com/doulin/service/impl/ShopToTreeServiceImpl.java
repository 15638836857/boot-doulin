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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @className ShopToTreeServiceImpl
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/26 16:26
 * @Version 1.0
 */
@Service
public class ShopToTreeServiceImpl implements ShopToTreeService {

    @Autowired
    private SykUtil sykUtil;
    @Autowired
    private TShopHomeBaseInfoService shopHomeBaseInfoService;
    @Autowired
    private ImgDoConfig imgDoConfig;

    @Transactional
    @Override
    public String operToSykAddOrUpdate(TShopHomeBaseInfo shopHomeBaseInfo, String cmd, String oper) throws Exception {
        String param = ShopImport.getParamAddOrUpdate(shopHomeBaseInfo, cmd, oper);
        String url = sykUtil.getHttpUrl() + "?" + param;
        String result = HttpUtil.post(url, "");
        JSONObject jsonObject = JSONUtil.parseObj(result);
        if (SysContent.STR_200.equals(jsonObject.getStr("result")) && SysContent.SUCCESS.equals(jsonObject.getStr("msg"))) {
            String upjson = getParamMchCertUpload(shopHomeBaseInfo);
            JSONObject object = JSONUtil.parseObj(upjson);
            if (SysContent.STR_200.equals(object.getStr("result")) && SysContent.SUCCESS.equals(object.getStr("msg"))) {
//
                return SysContent.OK_STR;
            } else {
                throw new Exception(object.getStr("msg"));
            }
        } else {
            throw new Exception(jsonObject.getStr("msg"));
        }
    }

    @Override
    public String getParamMchCertUpload(TShopHomeBaseInfo shopHomeBaseInfo) {
        String param = ShopImport.getParamMchCertUpload(shopHomeBaseInfo,imgDoConfig.getHost());
        String url = sykUtil.getHttpUrl() + "?" + param;
        String result = HttpUtil.post(url, "");
        return result;
    }
}
