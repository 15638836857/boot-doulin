package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopToucanHd;
import com.doulin.entity.vo.VQuery;

/**
* TShopToucanHdService
* @Author malinging
* @Date 2021-05-14
**/
public interface TShopToucanHdService extends IService<TShopToucanHd> {

    IPage<TShopToucanHd> page(VQuery query);

    /**
     * 根据商家编号和活动订单类型 获取信息
     * @param shopHomeCode
     * @param orderType FGTC:复购套餐/  DEJNZ:第二件N折/ JJG加价购
     * @return
     */
    TShopToucanHd getByShopHomeCodeAndOrderType(String shopHomeCode, String orderType);
}
