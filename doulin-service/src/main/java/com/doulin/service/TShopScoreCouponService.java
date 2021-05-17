package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopScoreCoupon;
import com.doulin.entity.vo.VQuery;

/**
* TShopScoreCouponService
* @Author malinging
* @Date 2021-05-13
**/
public interface TShopScoreCouponService extends IService<TShopScoreCoupon> {

    IPage<TShopScoreCoupon> page(VQuery query);

    /**
     * 优惠券 添加
     * @param oper
     * @param tShopScoreCoupon
     */
    void saveAndUpdate(String oper, TShopScoreCoupon tShopScoreCoupon) throws Exception;
}
