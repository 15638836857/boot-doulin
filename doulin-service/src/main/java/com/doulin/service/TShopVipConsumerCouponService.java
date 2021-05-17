package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopVipConsumerCoupon;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
* TShopVipConsumerCouponService
* @Author malinging
* @Date 2021-05-07
**/
public interface TShopVipConsumerCouponService extends IService<TShopVipConsumerCoupon> {

    IPage<TShopVipConsumerCoupon> page(VQuery query);

    /**
     * 消费券
     * @param oper
     * @param shopVipConsumerCoupon
     */
    void operData(String oper, TShopVipConsumerCoupon shopVipConsumerCoupon) throws Exception;

    /**
     * 获取商家消费券
     * @param loginNo
     * @param name 规则名称
     * @return
     */
    List<Map<String, Object>> getVipCoupons(String loginNo, String name);

    void updateByIdsAndVipBaseId(String[] ids, Integer vipBaseId);

    void updateVipByBaseId(Integer vipBaseId);
}
