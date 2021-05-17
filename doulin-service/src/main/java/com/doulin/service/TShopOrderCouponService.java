package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopOrderCoupon;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
* TShopOrderCouponService  商家设置订单返券
* @Author malinging
* @Date 2021-05-13
**/
public interface TShopOrderCouponService extends IService<TShopOrderCoupon> {

    IPage<TShopOrderCoupon> page(VQuery query);

    /**
     * 编辑/添加/删除/开启
     * @param oper
     * @param tShopOrderCoupon
     */
    void saveAndUpdate(String oper, TShopOrderCoupon tShopOrderCoupon) throws Exception;

    /**
     *
     * @param shopHomeCode
     * @param orderType DDFQ/订单返券,XNJDLQ/新人进店领券，JDLQ/进店领券
     * @return
     */
    List<TShopOrderCoupon> getInfoByShopHomeCode(String shopHomeCode,String orderType);
}
