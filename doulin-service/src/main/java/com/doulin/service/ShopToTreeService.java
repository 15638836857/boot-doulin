package com.doulin.service;

import com.doulin.entity.TShopHomeBaseInfo;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @className ShopToTreeService
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/26 16:23
 * @Version 1.0
 */
public interface ShopToTreeService {

    /**
     * 上传dao商云客
     * @param shopHomeBaseInfo
     * @param oper
     * @param cmd 方法名
     * @return
     */
    String operToSykAddOrUpdate(TShopHomeBaseInfo shopHomeBaseInfo,TShopHomeBaseInfo dbInfo, String cmd ,String oper) throws Exception;

    /**
     * 商家资料 上传
     * @param shopHomeBaseInfo
     * @return
     */
    String getParamMchCertUpload(TShopHomeBaseInfo shopHomeBaseInfo) throws UnsupportedEncodingException;

    /**
     * 添加或修改 固定二维码
     * @param oper  0:添加   1:修改
     * @param sykQrCodeId  固维编号(添加时不用传，由系统自动生成,修改时必传)
     * @param merSn  绑定商户号，  p4_bBind为1 需传此值  添加模式下必传
     * @return  map:{"detail_error_code":"","detail_error_des":"","sn":"BBN286L60","ImgUrl":"a.xfpay.cn/Qrcode/20/BBN286L60.jpg"}
     */
    Map<String,Object> qrcode(int oper, String sykQrCodeId, String merSn) throws Exception;
}
