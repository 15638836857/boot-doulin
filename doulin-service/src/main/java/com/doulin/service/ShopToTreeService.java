package com.doulin.service;

import com.doulin.entity.TShopHomeBaseInfo;

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
    String operToSykAddOrUpdate(TShopHomeBaseInfo shopHomeBaseInfo, String cmd ,String oper) throws Exception;

    /**
     * 商家资料 上传
     * @param shopHomeBaseInfo
     * @return
     */
    String getParamMchCertUpload(TShopHomeBaseInfo shopHomeBaseInfo);
}
